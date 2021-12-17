package Estruturas;

import Entidades.Jogo;

public class TabHashJogoId {
    int capacidade;
    int quantidade;
    ListaEncadeadaJogo[] dados;

    public TabHashJogoId(int cap) {
        this.capacidade = cap;
        this.quantidade = 0;
        dados = new ListaEncadeadaJogo[this.capacidade];

        for (int i = 0; i < this.capacidade; i++) {
            dados[i] = new ListaEncadeadaJogo();
        }
    }

    public int funcaoHash(Jogo jogo) {
        int posicao = jogo.getIdJogo();
        return (posicao % capacidade);
    }

    public void inserir(Jogo jogo) {
        int posicao = funcaoHash(jogo);
        dados[posicao].inserir(jogo);
        quantidade++;
    }

    public Jogo buscar(Jogo quem) {
        int posicao = funcaoHash(quem);
        Jogo aux = dados[posicao].localizar(quem);
        return aux;
    }

    public void imprimirTudo() {

        for (int i = 0; i < capacidade; i++) {
            System.out.println("Posição " + i);
            dados[i].imprimir();
        }
    }

}
