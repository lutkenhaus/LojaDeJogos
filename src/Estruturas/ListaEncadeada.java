package Estruturas;

import Entidades.Jogo;

public class ListaEncadeada {
    public ElementoJogo primeiro;
    public ElementoJogo ultimo;

    public ListaEncadeada(){
        primeiro = new ElementoJogo(null);
        ultimo = primeiro;
    }

    public void inserir(Jogo novo){
        ElementoJogo novoElemento = new ElementoJogo(novo);

        ultimo.setProx(novoElemento);
        ultimo = novoElemento;
    }

    public Jogo localizar(Jogo quem){
        ElementoJogo aux = primeiro.getProx();

        while(aux!=null){
            if(quem.igual(aux.getDadosJogo()))
                return aux.getDadosJogo();
            else aux = aux.getProx();
        }
        return null;
    }

    public Jogo retirar(Jogo quem){
        ElementoJogo aux = primeiro;

        while(aux.getProx()!=null){
            if(quem.igual(aux.getProx().getDadosJogo())){
                //código da retirada
                ElementoJogo auxRet = aux.getProx();
                
                aux.setProx(auxRet.getProx());
                auxRet.setProx(null);
                if(auxRet == ultimo)
                    ultimo = aux;

                return auxRet.getDadosJogo();
            }
            else aux = aux.getProx();
        }
        return null;
    }

    public void imprimir(){
        ElementoJogo aux = primeiro.getProx();
        
        while(aux!=null){
            System.out.println(aux.getDadosJogo().getNomeJogo() + " - "+ aux.getDadosJogo().getIdJogo());
            aux = aux.getProx();
        }
        System.out.println("FIM DA LISTA.");
    }
}
