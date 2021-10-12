// package trabalhoLojaJogos.trabLojaJogos;

class Jogo {
    private int idJogo;
    private String nomeJogo;
    private String plataforma;
    private String anoLançamento;
    private Double preco;

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

    public String getAnoLançamento() {
        return this.anoLançamento;
    }

    public void setAnoLançamento(String anoLançamento) {
        this.anoLançamento = anoLançamento;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}