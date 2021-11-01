import java.io.IOException;
import java.io.FileWriter;

// package trabalhoLojaJogos.trabLojaJogos;

class ListaCompra {
    private ElementoCompra head;
    private ElementoCompra tail;

    public boolean listaVazia() {
        if (head == null && tail == null)
            return true;
        else
            return false;
    }

    public void adicionarInicio(Compra compra) {

        ElementoCompra novo = new ElementoCompra(compra);

        if(listaVazia()) {
            head = novo;
            tail = novo;
         } else {
            // novo.vagaoPosterior = head;
            novo.setProx(head);
            head = novo;
            // novo.vagaoPosterior.vagaoAnterior = head;
            novo.getProx().setAnt(head);
        }
    }

    public void adicionarFinal(Compra compra) {

        ElementoCompra novo = new ElementoCompra(compra);

        if (listaVazia()) {
            head = novo;
            tail = novo;
        } else {
            // novo.vagaoPosterior = head;
            novo.setProx(head);
            // novo.vagaoAnterior = tail;
            novo.setAnt(tail);
            tail = novo;
            // novo.vagaoPosterior.vagaoAnterior = novo;
            novo.getProx().setAnt(novo);
            // novo.vagaoAnterior.vagaoPosterior = novo;
            novo.getAnt().setProx(novo);
        }
    }

    public void imprimir() {
        ElementoCompra aux = head;

        while (aux != null) {
            Compra compra = aux.getDadosCompra();

            System.out.println("- Compra -");
            System.out.println(compra.toString());
            
            if (aux.getAnt() != null)
                System.out.println("ID Anterior: " + aux.getAnt().getDadosCompra().getIdJogo());
            if (aux.getProx() != null)
                System.out.println("ID Posterior: " + aux.getProx().getDadosCompra().getIdJogo());
            System.out.println("------------------------------------");
            aux = aux.getProx();
        }
    }

    public int contaGasto(String cpf) {
        ElementoCompra aux = head;
        int contador = 0;

        while (aux != null) {
            Compra compra = aux.getDadosCompra();
            if (cpf.equals(compra.getCpf())) contador++;
            aux = aux.getProx();
        }

        return contador;
    }

    public void toFile(String fileName) throws IOException {
        FileWriter outputFile = new FileWriter(fileName);
        ElementoCompra aux = head;

        while (aux != null) {
            Compra compra = aux.getDadosCompra();
            outputFile.write("- Compra -\n");
            outputFile.write(compra.toString() + "\n");
            aux = aux.getProx();
        }

        outputFile.close();
    }
    
}