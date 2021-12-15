package Entidades;

public class Jogo {
    private int idJogo;
    private String nomeJogo;
    private String plataforma;
    private String anoLancamento;
    private Double preco;

    /* Propriedade extra que armazena o calculo posterior da media das avaliacoes */
    private Double mediaAvaliacoes;

    public Jogo(int idJogo, String nomeJogo, String plataforma, String anoLancamento, Double preco) {
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
        this.plataforma = plataforma;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
        this.mediaAvaliacoes = 0.0;
    }

    public int getIdJogo() {
        return this.idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return this.nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getAnoLancamento() {
        return this.anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getMediaAvaliacoes() {
        return this.mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }

    public boolean igual(Jogo jogo) {
        return this.idJogo == jogo.idJogo;
    }

    public boolean menor(Jogo jogo) {
        return this.getMediaAvaliacoes() < jogo.getMediaAvaliacoes();
    }

    public boolean maior(Jogo jogo) {
        return this.getMediaAvaliacoes() > jogo.getMediaAvaliacoes();
    }

}