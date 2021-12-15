package Estruturas;

import Entidades.Compra;

public class ListaEncadeadaCompra {
    public ElementoCompra primeiro;
    public ElementoCompra ultimo;

    public ListaEncadeadaCompra(){
        primeiro = new ElementoCompra(null);
        ultimo = primeiro;
    }

    public void inserir(Compra novo){
        ElementoCompra novoElemento = new ElementoCompra(novo);

        ultimo.setProx(novoElemento);
        ultimo = novoElemento;
    }

    public Compra localizar(Compra quem){
        ElementoCompra aux = primeiro.getProx();

        while(aux!=null){
            if(quem.igual(aux.getDadosCompra()))
                return aux.getDadosCompra();
            else aux = aux.getProx();
        }
        return null;
    }

    public Double getMediaAvaliacoes() {
        ElementoCompra aux = primeiro.getProx();
        Double total = 0.0;
        int quantidade = 0;
        
        while(aux!=null){
            quantidade++;
            total += aux.getDadosCompra().getavaliacaoDoJogo();
            aux = aux.getProx();
        }

        return total/quantidade;
    }

    public void imprimir(){
        ElementoCompra aux = primeiro.getProx();
        
        while(aux!=null){
            System.out.println(aux.getDadosCompra().getIdJogo() + " - "+ aux.getDadosCompra().getCpf());
            aux = aux.getProx();
        }
    }
}
