public class OrdemServico {
    private int codigo;
    private String nomeCliente;
    private String modeloVeiculo;
    private String placaVeiculo;
    private String data;
    private StatusOrdem status;
    private double valorEstimado;
    private Servico servico;
    private Box boxAtribuido;

    public OrdemServico(int codigo, String nomeCliente, String modeloVeiculo, String placaVeiculo, String data, double valorEstimado, Servico servico) {
    this.codigo = codigo;
    this.nomeCliente = nomeCliente;
    this.modeloVeiculo = modeloVeiculo;
    this.placaVeiculo = placaVeiculo;
    this.data = data;
    this.status = StatusOrdem.ABERTA; 
    this.valorEstimado = valorEstimado;
    this.servico = servico;
    this.boxAtribuido = null;
    }
    public OrdemServico(){

    }

    public int getCodigo() {
    return codigo;
    }

    public String getNomeCliente() {
    return nomeCliente;
    }

    public String getModeloVeiculo() {
    return modeloVeiculo;
    }

    public String getPlacaVeiculo() {
    return placaVeiculo;
    }

    public String getData() {
    return data;
    }

    public StatusOrdem getStatus() {
    return status;
    }

    public void setStatus(StatusOrdem status) {
    this.status = status;
    }

    public double getValorEstimado() {
    return valorEstimado;
    }

    public Servico getServico() {
    return servico;
    }

    public Box getBoxAtribuido() {
    return boxAtribuido;
    }

    public void setBoxAtribuido(Box boxAtribuido) {
    this.boxAtribuido = boxAtribuido;
    }

    public void exibirDetalhes() {
    System.out.println("Ordem de Serviço " + codigo);
    System.out.println("Cliente: " + nomeCliente);
    System.out.println("Veículo: " + modeloVeiculo + "Placa: " + placaVeiculo);
    System.out.println("Data: " + data + "Status: " + status);
    System.out.println("Valor Estimado: R$ " + valorEstimado);
    System.out.println(servico.toString());

    if (boxAtribuido != null) {
        
    System.out.println("Box:" + boxAtribuido.getNumero() + " (" + boxAtribuido.getLocalizacao() + ")");

    if (boxAtribuido.getMecanicoResponsavel() != null) {

    System.out.println("Mecânico Responsável: " + boxAtribuido.getMecanicoResponsavel().getNome());

    } else {

    System.out.println("Mecânico Responsável: Sem mecânico associado ao box.");

    }
    } else {

    System.out.println("Box: Nenhum box atribuído.");

    }
    }
    }
        
