package Estruturas;

import Entidades.*;

public class TabHashCompras {
    int capacidade;
    int quantidade;
    ListaEncadeadaCompra[] dados;
    
    public TabHashCompras(int cap){
        this.capacidade = cap;
        this.quantidade = 0;
        dados = new ListaEncadeadaCompra[this.capacidade];  // o que temos no vetor agora? NADA!!!

        for(int i=0; i<this.capacidade; i++){
            dados[i] = new ListaEncadeadaCompra();
        }   //agora sim, temos uma lista vazia em cada posição.
    }

    public int funcaoHash(Compra compra){
        int posicao = compra.getIdJogo();
        return(posicao % capacidade);
    }

    public void inserir(Compra compra){
        int posicao = funcaoHash(compra);
        dados[posicao].inserir(compra);
        quantidade++;
    }

    public ListaEncadeadaCompra buscar(Compra quem){        //compra "mock" para busca
        int posicao = funcaoHash(quem);
        return dados[posicao];
    }

    public ListaEncadeadaJogo getJogosMaisBemAvaliados(TabHashJogoId tabelaJogos) {
        ListaEncadeadaJogo jogos = new ListaEncadeadaJogo();
        for (int i=0; i<dados.length; i++) {
            ElementoCompra elementoCompraAtual = dados[i].primeiro.getProx();
            if (elementoCompraAtual == null || elementoCompraAtual.getDadosCompra() == null) {
                continue;
            }

            Jogo jogo = tabelaJogos.buscar(new Jogo(elementoCompraAtual.getDadosCompra().getIdJogo(), "", "", "", 0.0));
            jogo.setMediaAvaliacoes(dados[i].getMediaAvaliacoes());
            insereJogoOrdernadoAvaliacao(jogos, jogo);
        }

        limitaListaJogos(jogos);
        return jogos;
    }

    public void insereJogoOrdernadoAvaliacao(ListaEncadeadaJogo jogos, Jogo jogo) {
        ElementoJogo anterior = null;
        boolean inserido = false;

        for (ElementoJogo elementoJogo = jogos.primeiro.getProx(); elementoJogo != null; elementoJogo = elementoJogo.getProx()) {
            if (elementoJogo.getDadosJogo().menor(jogo)) {
                ElementoJogo novoElemento = new ElementoJogo(jogo);       
                novoElemento.setProx(elementoJogo);

                if (anterior != null) {
                    anterior.setProx(novoElemento);
                } else {
                    jogos.primeiro.setProx(novoElemento);
                }

                inserido = true;
                break;
            }
            anterior = elementoJogo;
        }

        if (!inserido) {
            jogos.inserir(jogo);
        }
    }

    public void limitaListaJogos(ListaEncadeadaJogo jogos) {
        int quantidade = 0;
        for (ElementoJogo elementoJogo = jogos.primeiro.getProx(); elementoJogo != null; elementoJogo = elementoJogo.getProx()) {
            quantidade++;
            if (quantidade >= 10) {
                elementoJogo.setProx(null);
            }
        }
    }

    public void imprimirTudo(){
        
        for(int i=0; i<capacidade; i++){
            System.out.println("Posição "+i);
            dados[i].imprimir();
            System.out.println("Média das avaliações: " + dados[i].getMediaAvaliacoes()); 
        }
    }
    
}
