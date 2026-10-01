import java.util.List;
import java.util.ArrayList;

public class Box{
    private int numero;
    private String tipoServico;
    private int capacidade;
    private String localizacao;
    private Mecanico mecanico;
    private List<OrdemServico> ordens;
    private int totalOrdens;


    public Box(int numero, String tipoServico, int capacidade, String localizacao){
        this.numero=numero;
        this.tipoServico;
        this.capacidade=capacidade;
        this.localizacao=localizacao;
        this.mecanico=null;
        this.ordens=new ArrayList<>();
        this.totalOrdens=totalOrdens;
    }

    public int getNumero() {
    return numero;
    }

    public String getTipoServico() {
    return tipoServico;
    }

    public int getCapacidade() {
    return capacidade;
    }

    public String getLocalizacao() {
    return localizacao;
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

    public void incrementarOrdens() {
    this.totalOrdens++;
    }

    public boolean adicionarOrdem(OrdemServico ordem) {
    if (ordens.size() >= capacidade) {
    System.out.println("Erro: Box " + numero + "ta com cap. max de " + capacidade + " veículos.");
    return false;
    }

    ordens.add(ordem);
    return true;
    }

    public void removerOrdem(OrdemServico ordem) {
    ordens.remove(ordem);
    }
}

