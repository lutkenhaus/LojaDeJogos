package Entidades;

import Estruturas.ListaCompra;
import Estruturas.TabHashJogoId;
import Estruturas.ElementoCompra;

public class Cliente {
    private String cpf;
    private String nome;
    private String nickname;
    private String senha;

    private ListaCompra listaCompras;

    public Cliente(String cpf, String nome, String nickname, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.nickname = nickname;
        this.senha = senha;
        this.listaCompras = new ListaCompra();
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ListaCompra getlistaCompras() {
        return this.listaCompras;
    }

    public void setlistaCompras(ListaCompra listaCompras) {
        this.listaCompras = listaCompras;
    }

    public boolean igual(Cliente outro){
        return this.cpf.equals(outro.cpf);
    }

    public boolean ehMenorQue(Cliente outro){
        return this.cpf.compareTo(outro.cpf) < 0;
    }

    public Double contaGasto(TabHashJogoId tabelaJogos) {
        ElementoCompra aux = listaCompras.getElementoHead();
        Double totalGasto = 0.0;

        while (aux != null) {
            Jogo jogoAux = tabelaJogos.buscar(new Jogo(aux.getDadosCompra().getIdJogo(), "", "", "", 0.0));
            totalGasto += jogoAux.getPreco();
            aux = aux.getProx();
        }

        return totalGasto;
    }

    public String dadosCliente(TabHashJogoId tabelaJogos) {
        String auxDados="---------------------\n";
        auxDados+= "CPF: " + this.cpf + "\n";
        auxDados+= "Nome: " + this.nome + "\n";
        auxDados+= "Nickname: " + this.nickname + "\n";
        auxDados+= "Senha: " + this.senha + "\n";
        auxDados+= "Total gasto: " + this.contaGasto(tabelaJogos) + "\n";
        return auxDados;
    }
}
