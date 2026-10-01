import java.util.ArrayList;
import java.util.List;
import.java.util.Scanner;

public class Main{
    private static List<Mecanico> mecanicos = new ArrayList<>();
    private static List<Box> boxes = new ArrayList<>();
    private static List<OrdemServico> ordens = new ArrayList<>();


    public static void Dados(){
        Mecanico m1=new Mecanico("Jonatan silva", "11122233344", "Freioslakkk", "3299993333");
       Mecanico m2=new Mecanico("Marcelinho junior", "22233311198", "Marcha", "3199880456");
       Mecanico m3=new Mecanico("Pedro mario", "12345678910", "Suspensao", "3199995657");

       mecanicos.add(m1);
       mecanicos.add(m2);
       mecanicos.add(m3);


       Box b1=new Box(1, "Freioslakkk", 1, "Setor A");
       Box b2=new Box(2, "Marcha", 2, "Setor B");
       Box b3=new Box(1, "Suspensao", 3, "Setor C");

       boxes.add(b1);
       boxes.add(b2);
       boxes.add(b3);



    }


    public static void main(String [] args){

        Scanner sc = new Scanner (System.in);

        Dados();

        int opcao=-1;

        do{

            System.out.println("\n Sistem oficina \n");

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

            opcao=sc.nextInt();
            sc.nextLine();

            switch(opcao){
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
        }while(opcao != 0);

        sc.close();
    }

    private static void cadastrarOrdemServico(Scanner sc){
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


}