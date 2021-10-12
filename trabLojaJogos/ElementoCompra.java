// package trabalhoLojaJogos.trabLojaJogos;

class ElementoCompra {
    private Compra dadosCompra;
    private ElementoCompra prox;
    private ElementoCompra ant;

    public ElementoCompra(Compra compra) {
        this.dadosCompra = compra;
    }

    public Compra getDadosCompra() {
        return this.dadosCompra;
    }

    public void setDadosCompra(Compra dadosCompra) {
        this.dadosCompra = dadosCompra;
    }

    public ElementoCompra getProx() {
        return this.prox;
    }

    public void setProx(ElementoCompra prox) {
        this.prox = prox;
    }

    public ElementoCompra getAnt() {
        return this.ant;
    }

    public void setAnt(ElementoCompra ant) {
        this.ant = ant;
    }
}