// package trabalhoLojaJogos.trabLojaJogos;

class Compra {
    private String cpf;
    private int idJogo;
    private String data;
    private int avaliaçãoDoJogo;

    public Compra(String cpf, int idJogo, String data, int avaliaçãoDoJogo) {
        this.cpf = cpf;
        this.idJogo = idJogo;
        this.data = data;
        this.avaliaçãoDoJogo = avaliaçãoDoJogo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdJogo() {
        return this.idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAvaliaçãoDoJogo() {
        return this.avaliaçãoDoJogo;
    }

    public void setAvaliaçãoDoJogo(int avaliaçãoDoJogo) {
        this.avaliaçãoDoJogo = avaliaçãoDoJogo;
    }

    public String toString() {
        return "CPF: " + this.cpf + " | Id: " + this.idJogo + " | Data: " + this.data + " | Avaliação: " + this.avaliaçãoDoJogo;
    }
}