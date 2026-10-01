    import java.util.ArrayList;
    import java.util.List;

    public class Box {
    private int numero;
    private String tipoServico;
    private int capacidadeMaxima;
    private String localizacao;
    private Mecanico mecanico;
    private List<OrdemServico> ordens = new ArrayList<>();
    private int totalOrdens = 0;

    public Box(int numero, String tipoServicoPermitido, int capacidadeMaxima, String localizacao) {
    this.numero = numero;
    this.tipoServicoPermitido = tipoServico;
    this.capacidadeMaxima = capacidadeMaxima;
    this.localizacao = localizacao;
    }

    public int getNumero() {
    return numero;
    }

    public Mecanico getMecanico() {
    return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
    this.mecanico = mecanico;
    }

    public List<OrdemServico> getOrdens() {
    return ordens;
    }

    public int getTotalOrdens() {
    return totalOrdens;
    }

    public boolean adicionarOrdem(OrdemServico os) {
    if (ordens.size() < capacidadeMaxima) {
    ordens.add(os);
    return true;
    }
    return false;
    }
    }
