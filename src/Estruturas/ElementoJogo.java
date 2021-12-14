package Estruturas;

import Entidades.Jogo;

public class ElementoJogo {
    private Jogo dadosJogo;
    private ElementoJogo prox;
    private ElementoJogo ant;

    public ElementoJogo(Jogo compra) {
        this.dadosJogo = compra;
    }

    public Jogo getDadosJogo() {
        return this.dadosJogo;
    }

    public void setDadosJogo(Jogo dadosJogo) {
        this.dadosJogo = dadosJogo;
    }

    public ElementoJogo getProx() {
        return this.prox;
    }

    public void setProx(ElementoJogo prox) {
        this.prox = prox;
    }

    public ElementoJogo getAnt() {
        return this.ant;
    }

    public void setAnt(ElementoJogo ant) {
        this.ant = ant;
    }
}