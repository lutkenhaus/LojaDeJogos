package Estruturas;

import Entidades.Cliente;

public class ABB {
    Nodo raiz;
    ABB subarvoreEsquerda;
    ABB subarvoreDireita;


    public ABB(Cliente quem){
        raiz = new Nodo(quem);
        subarvoreDireita = null;
        subarvoreEsquerda = null;
    }

    public int grau(){
        if(subarvoreDireita == null){  //não existe direita
            if(subarvoreEsquerda == null) // nem esquerda
                return 0;
            else                // existe esquerda, não direita.
                return -1;      
        }
        else {  //existe direita
            if(subarvoreEsquerda == null)  //mas não existe esquerda
                return 1;
            else            //também existe esquerda, junto com a direita.
                return 2;
        }
    }

    /**
     * Retorna o maior entre os menores (antecessor)
     * @return A subárvore com o elemento antecessor. 
     */
    public ABB antecessor(){
        ABB aux = subarvoreEsquerda;
        
        while(aux.subarvoreDireita != null)
                aux = aux.subarvoreDireita;

        return aux;
    }


    public ABB retirar(Cliente quem, ABB subarvore){
        if(subarvore == null){
            return null;
        }
        else{
            if(quem.igual(subarvore.raiz.meuCliente)){
                int grau = subarvore.grau();
                switch(grau){
                    case 0: return null;
                      
                    case 1: return subarvore.subarvoreDireita;
                      
                    case -1: return subarvore.subarvoreEsquerda;
                      
                    case 2:  subarvore.raiz =  subarvore.antecessor().raiz;
                             subarvore.subarvoreEsquerda = retirar(subarvore.raiz.meuCliente, subarvore.subarvoreEsquerda);
                             return subarvore;
                   
                    default: return null;
                }
            }
            else{
 
               if(quem.ehMenorQue(subarvore.raiz.meuCliente))
                    subarvore.subarvoreEsquerda = retirar(quem, subarvore.subarvoreEsquerda);
                else
                    subarvore.subarvoreDireita = retirar(quem, subarvore.subarvoreDireita);
 
                return subarvore;
            }
        }
   }

    public ABB inserir(Cliente novo, ABB subarvore){
         if(subarvore == null){
             ABB novaSubarvore = new ABB(novo);
             return novaSubarvore;
         }   
         else{
            if(novo.ehMenorQue(subarvore.raiz.meuCliente))
                  subarvore.subarvoreEsquerda = inserir(novo, subarvore.subarvoreEsquerda);
            else
                  subarvore.subarvoreDireita =  inserir(novo, subarvore.subarvoreDireita);
            
            return subarvore;
         }    
    }

    public Cliente buscaCliente(Cliente quem, ABB subarvore){
        if(subarvore == null){
            return null;
        }
        else{
            if(quem.igual(subarvore.raiz.meuCliente))
                return subarvore.raiz.meuCliente;
            else
                if(quem.ehMenorQue(subarvore.raiz.meuCliente))
                    return buscaCliente(quem, subarvore.subarvoreEsquerda);
                else
                    return buscaCliente(quem, subarvore.subarvoreDireita);
        }
    }

    public String dadosArvore(ABB subarvore){
        if(subarvore == null)
            return "";
        else{
            String aux = dadosArvore(subarvore.subarvoreEsquerda);
            aux += subarvore.raiz.meuCliente.dadosCliente();
            aux += dadosArvore(subarvore.subarvoreDireita);
            return aux;
        }
    }


}
