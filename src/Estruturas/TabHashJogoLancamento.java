package Estruturas;

import Entidades.Jogo;

public class TabHashJogoLancamento {
    int capacidade;
    int quantidade;
    ListaEncadeadaJogo[] dados;
    
    public TabHashJogoLancamento(int cap){
        this.capacidade = cap;
        this.quantidade = 0;
        dados = new ListaEncadeadaJogo[this.capacidade];  // o que temos no vetor agora? NADA!!!

        for(int i=0; i<this.capacidade; i++){
            dados[i] = new ListaEncadeadaJogo();
        }   //agora sim, temos uma lista vazia em cada posição.
    }

    public int funcaoHash(Jogo jogo){
        int posicao = Integer.parseInt(jogo.getAnoLançamento());
        return(posicao % capacidade);
    }

    public void inserir(Jogo jogo){
        int posicao = funcaoHash(jogo);
        dados[posicao].inserir(jogo);
        quantidade++;
    }

    public ListaEncadeadaJogo buscar(Jogo quem){        //jogo "mock" para busca
        int posicao = funcaoHash(quem);
        return dados[posicao];
    }

    public void imprimirTudo(){
        
        for(int i=0; i<capacidade; i++){
            System.out.println("Posição "+i);
            dados[i].imprimir(); 
        }
    }
    
}
