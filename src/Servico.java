public class Servico{
    private String nome;
    private int tempo;
    private double valor;
    private String  categoria;



    public Servico(String nome, int tempo, double valor, String categoria){
        this.nome=nome;
        this.tempo=tempo;
        this.valor=valor;
        this.categoria=categoria;
    }

    public Servico(){

    }

    public String getNome() {
    return nome;
    }

    public void setNome(String nome) {
    this.nome = nome;
    }

    public int getTempoEstimado() {
    return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
    this.tempoEstimado = tempoEstimado;
    }

    public double getValor() {
    return valor;
    }

    public void setValor(double valor) {
    this.valor = valor;
    }

    public String getCategoria() {
    return categoria;
    }

    public void setCategoria(String categoria) {
    this.categoria = categoria;
    }

    public String toString() {
    return "Serviço : " + nome + "Categoria : " + categoria + "Tempo Estimado : " + tempoEstimado + "Valor: R$ " + valor;
    }
}