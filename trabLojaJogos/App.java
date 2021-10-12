// package trabalhoLojaJogos.trabLojaJogos;

import java.io.*;
import java.util.Scanner;
import java.util.*;

class App {

    public static void main(String[] args) throws Exception {
        ListaCompra lista;
        lista = montaListaCompra("../arquivosLoja/ComprasJogos1.txt");
        // lista.imprimir();
        lista.toFile("output");
    }

    static ListaCompra montaListaCompra(String nomeArquivo) throws Exception {

        ListaCompra lista = new ListaCompra();
        File arquivoCompra = new File(nomeArquivo);
        Scanner leitor = new Scanner(arquivoCompra);

        while (leitor.hasNextLine()) {
            String line = leitor.nextLine();
            Compra compra = getCompraFromLine(line);
            lista.adicionarInicio(compra);
        }

        leitor.close();
        return lista;
    }

    public static Compra getCompraFromLine(String line) {
        String[] lParts = line.split(";");
        Compra c = new Compra(lParts[0], Integer.parseInt(lParts[1]), lParts[2], Integer.parseInt(lParts[3]));
        return c;
    }
}