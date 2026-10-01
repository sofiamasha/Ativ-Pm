    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {
    private static List<Mecanico> mecanicos = new ArrayList<>();
    private static List<Box> boxes = new ArrayList<>();
    private static List<OrdemServico> ordens = new ArrayList<>();
    private static int geradorCodigoOrdem = 1;

    public static void Dados() {
    Mecanico m1 = new Mecanico("Jonatan silva", "11122233344", "Freioslakkk", "3299993333");
    Mecanico m2 = new Mecanico("Marcelinho junior", "22233311198", "Marcha", "3199880456");
    Mecanico m3 = new Mecanico("Pedro mario", "12345678910", "Suspensao", "3199995657");

    mecanicos.add(m1);
    mecanicos.add(m2);
    mecanicos.add(m3);

    Box b1 = new Box(1, "Freioslakkk", 1, "Setor A");
    Box b2 = new Box(2, "Marcha", 2, "Setor B");
    Box b3 = new Box(3, "Suspensao", 3, "Setor C");

    boxes.add(b1);
    boxes.add(b2);
    boxes.add(b3);
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Dados();

    int opcao = -1;

    do {
    System.out.println("\n Sistema oficina \n");
    System.out.println("1-Cadastrar ordem de serviço");
    System.out.println("2-Associar um mecânico a um box");
    System.out.println("3-Atribuir ordem de serviço a um box");
    System.out.println("4-Exibir ordens de um box específico");
    System.out.println("5-Informar quantidade de ordens finalizadas por cada box");
    System.out.println("6-Buscar ordens por status");
    System.out.println("7-Exibir detalhes completos de uma ordem");
    System.out.println("8-Alterar status de uma ordem");
    System.out.println("0-Sair");
    System.out.print("Escolha qual opcao vc quer: ");

    opcao = sc.nextInt();
    sc.nextLine();

    switch (opcao) {
    case 1:
    cadastrarOrdemServico(sc);
    break;
    case 2:
    associarMecanicoBox(sc);
    break;
    case 3:
    atribuirOrdemBox(sc);
    break;
    case 4:
    exibirOrdensPorBox(sc);
    break;
    case 5:
    informarOrdensFinalizadasPorBox();
    break;
    case 6:
    buscarOrdensPorStatus(sc);
    break;
    case 7:
    exibirDetalhesOrdem(sc);
    break;
    case 8:
    alterarStatusOrdem(sc);
    break;
    case 0:
    System.out.println("FIM");
    break;
    default:
    System.out.println("Opção invalida");
    }
    } while (opcao != 0);

    sc.close();
    }

    private static void cadastrarOrdemServico(Scanner sc) {
    System.out.print("Nome do cliente : ");
    String cliente = sc.nextLine();

    System.out.print("Modelo do veículo : ");
    String modelo = sc.nextLine();

    System.out.print("Placa do veículo: ");
    String placa = sc.nextLine();

    System.out.print("Data : ");
    String data = sc.nextLine();

    System.out.print("Valor : ");
    double valorEstimado = sc.nextDouble();
    sc.nextLine();

    System.out.print("Nome do serviço : ");
    String nomeServico = sc.nextLine();

    System.out.print("Tempo estimado em minuto: ");
    int tempoEstimado = sc.nextInt();

    System.out.print("Valor do serviço : ");
    double valorServico = sc.nextDouble();
    sc.nextLine();

    System.out.print("Categoria do serviço: ");
    String categoria = sc.nextLine();

    Servico servico = new Servico(nomeServico, tempoEstimado, valorServico, categoria);
    OrdemServico novaOrdem = new OrdemServico(geradorCodigoOrdem++, cliente, modelo, placa, data, valorEstimado, servico);

    ordens.add(novaOrdem);
    System.out.println("Ordem cadastrada. Código: " + novaOrdem.getCodigo());
    }

    private static void associarMecanicoBox(Scanner sc) {
    System.out.println("Mecânicos cadastrados:");
    for (int i = 0; i < mecanicos.size(); i++) {
    Mecanico m = mecanicos.get(i);

    String temBoxTexto;
    if (m.isTemBox()) {
    temBoxTexto = "Sim";
    } else {
    temBoxTexto = "Não";
    }

    System.out.println(i + "" + m.getNome() + " | Tem Box? " + temBoxTexto);
    }

    System.out.print("Selecione o mecânico: ");
    int idMecanico = sc.nextInt();

    if (idMecanico < 0 || idMecanico >= mecanicos.size()) {
    System.out.println("Mecânico inválido.");
    return;
    }

    Mecanico mecanico = mecanicos.get(idMecanico);

    if (mecanico.isTemBox()) {
    System.out.println("Erro: O mecânico " + mecanico.getNome() + " já tem uma box");
    return;
    }

    System.out.println("Boxes cadastrados:");
    for (int i = 0; i < boxes.size(); i++) {
    Box b = boxes.get(i);

    String resp;
    if (b.getMecanicoResponsavel() != null) {
    resp = b.getMecanicoResponsavel().getNome();
    } else {
    resp = "Nenhum";
    }

    System.out.println(i + " Box " + b.getNumero() + " (" + b.getTipoServicoPermitido() + ") Responsável: " + resp);
    }

    System.out.print("Selecione o box: ");
    int idBox = sc.nextInt();

    if (idBox < 0 || idBox >= boxes.size()) {
    System.out.println("Box inválido");
    return;
    }

    Box box = boxes.get(idBox);

    if (box.getMecanicoResponsavel() != null) {
    box.getMecanicoResponsavel().setTemBox(false);
    }

    box.setMecanicoResponsavel(mecanico);
    mecanico.setTemBox(true);

    System.out.println("Mecânico " + mecanico.getNome() + " associado ao Box " + box.getNumero() + " com sucesso");
    }

    private static void atribuirOrdemBox(Scanner sc) {
    List<OrdemServico> ordensAbertas = new ArrayList<>();
    for (OrdemServico os : ordens) {
    if (os.getStatus() == StatusOrdem.ABERTA) {
    ordensAbertas.add(os);
    }
    }

    if (ordensAbertas.isEmpty()) {
    System.out.println("Não há ordens precisando de box");
    return;
    }

    System.out.println("Ordens de serviço abertas:");
    for (int i = 0; i < ordensAbertas.size(); i++) {
    OrdemServico os = ordensAbertas.get(i);
    System.out.println(i + "Código: " + os.getCodigo() + "Cliente: " + os.getNomeCliente() + "Serviço: " + os.getServico().getNome());
    }

    System.out.print("Selecione a ordem: ");
    int idOrdem = sc.nextInt();

    if (idOrdem < 0 || idOrdem >= ordensAbertas.size()) {
    System.out.println("Ordem inválida.");
    return;
    }

    OrdemServico ordemSelecionada = ordensAbertas.get(idOrdem);

    System.out.println("Boxes cadastrados:");
    for (int i = 0; i < boxes.size(); i++) {
    Box b = boxes.get(i);
    System.out.println(i + "Box " + b.getNumero() + "Tipo: " + b.getTipoServicoPermitido() + "Ocupação: " + b.getOrdens().size() + "/" + b.getCapacidadeMaxima());
    }

    System.out.print("Selecione o box: ");
    int idBox = sc.nextInt();

    if (idBox < 0 || idBox >= boxes.size()) {
    System.out.println("Box inválido.");
    return;
    }

    Box boxSelecionado = boxes.get(idBox);

    if (boxSelecionado.adicionarOrdem(ordemSelecionada)) {
    ordemSelecionada.setBoxAtribuido(boxSelecionado);
    ordemSelecionada.setStatus(StatusOrdem.EM_EXECUCAO);
    System.out.println("Ordem " + ordemSelecionada.getCodigo() + " atribuída ao Box " + boxSelecionado.getNumero() + " com sucesso");
    }
    }

    private static void exibirOrdensPorBox(Scanner sc) {
    for (int i = 0; i < boxes.size(); i++) {
    System.out.println(i + " - Box " + boxes.get(i).getNumero());
    }

    System.out.print("Selecione o box: ");
    int idBox = sc.nextInt();

    if (idBox < 0 || idBox >= boxes.size()) {
    System.out.println("Box inválido.");
    return;
    }

    Box box = boxes.get(idBox);
    List<OrdemServico> listaOrdens = box.getOrdens();

    System.out.println("\nOrdens no Box " + box.getNumero() + ":");
    for (OrdemServico os : listaOrdens) {
    System.out.println("Código: " + os.getCodigo() + "Cliente: " + os.getNomeCliente() + "Veículo: " + os.getModeloVeiculo() + "Status: " + os.getStatus());
    }
    System.out.println("Total de ordens no box: " + listaOrdens.size());
    }

    private static void informarOrdensFinalizadasPorBox() {
    for (Box b : boxes) {
    System.out.println("Box " + b.getNumero() + " (" + b.getLocalizacao() + "): " + b.getTotalOrdensFinalizadas() + " ordem(ns) finalizada(s)");
    }
    }

    private static void buscarOrdensPorStatus(Scanner sc) {
    System.out.println("1 - ABERTA | 2 - EM_EXECUCAO | 3 - FINALIZADA");
    System.out.print("Escolha o status: ");
    int op = sc.nextInt();

    StatusOrdem statusBuscado = null;
    if (op == 1) {
    statusBuscado = StatusOrdem.ABERTA;
    } else if (op == 2) {
    statusBuscado = StatusOrdem.EM_EXECUCAO;
    } else if (op == 3) {
    statusBuscado = StatusOrdem.FINALIZADA;
    } else {
    System.out.println("Opção inválida.");
    return;
    }

    boolean encontrou = false;
    for (OrdemServico os : ordens) {
    if (os.getStatus() == statusBuscado) {
    os.exibirDetalhesCompletos();
    encontrou = true;
    }
    }
    if (!encontrou) {
    System.out.println("Nenhuma ordem encontrada.");
    }
    }

    private static void exibirDetalhesOrdem(Scanner sc) {
    System.out.print("Informe o código da ordem: ");
    int cod = sc.nextInt();

    for (OrdemServico os : ordens) {
    if (os.getCodigo() == cod) {
    os.exibirDetalhesCompletos();
    return;
    }
    }
    System.out.println("Ordem não encontrada.");
    }

    private static void alterarStatusOrdem(Scanner sc) {
    System.out.print("Informe o código da ordem: ");
    int cod = sc.nextInt();

    OrdemServico ordem = null;
    for (OrdemServico os : ordens) {
    if (os.getCodigo() == cod) {
    ordem = os;
    break;
    }
    }

    if (ordem == null) {
    System.out.println("Ordem não encontrada.");
    return;
    }

    if (ordem.getStatus() == StatusOrdem.EM_EXECUCAO) {
    Box box = ordem.getBoxAtribuido();
    if (box != null) {
    box.removerOrdem(ordem);
    box.incrementarFinalizadas();
    }
    ordem.setStatus(StatusOrdem.FINALIZADA);
    System.out.println("Ordem finalizada com sucesso!");
    } else {
    System.out.println("A ordem não está em execução para poder ser finalizada.");
    }
    }
    }