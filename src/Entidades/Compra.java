package Entidades;

public class Compra {
    private String cpf;
    private int idJogo;
    private String data;
    private int avaliacaoDoJogo;

    public Compra(String cpf, int idJogo, String data, int avaliacaoDoJogo) {
        this.cpf = cpf;
        this.idJogo = idJogo;
        this.data = data;
        this.avaliacaoDoJogo = avaliacaoDoJogo;
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

    public int getavaliacaoDoJogo() {
        return this.avaliacaoDoJogo;
    }

    public void setavaliacaoDoJogo(int avaliacaoDoJogo) {
        this.avaliacaoDoJogo = avaliacaoDoJogo;
    }

    public String toString() {
        return "CPF: " + this.cpf + " | Id: " + this.idJogo + " | Data: " + this.data + " | Avaliação: " + this.avaliacaoDoJogo;
    }
}