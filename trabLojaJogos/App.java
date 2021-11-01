// package trabalhoLojaJogos.trabLojaJogos;

import java.io.*;
import java.util.Scanner;
import java.util.*;

class App {

    public static void main(String[] args) throws Exception {
        // Carrega estruturas
        ABB arvoreClientes = montaArvoreClientes("../arquivosLoja/ClientesJogos_2021-2.txt");
        ListaCompra listaCompras = montaListaCompra("../arquivosLoja/ComprasJogos1.txt");

        Scanner in = new Scanner(System.in);
        String buscaCpf;
        limparTela();
        int opc = 54, ok = 0;

		while (opc != 0) {
			System.out.println("/ Loja de Jogos /");
			System.out.println("(1) Buscar cliente");
			System.out.println("(2) Contar gasto total");
			System.out.println("(0) Para sair");
			System.out.printf("\nDigite a opção desejada: ");
			do {
				opc = Integer.parseInt(in.nextLine());
				if (opc >= 0 && opc <= 5) {
					ok = 1;
				} else {
					System.out.printf("\n\tOPÇÃO INVÁLIDA! Digite novamente: ");
				}
			} while (ok == 0);
			switch (opc) {
                case 1:
                    System.out.print("CPF a ser pesquisado: ");
                    buscaCpf = in.nextLine();
                    try {
                        Cliente busca = arvoreClientes.buscaCliente(new Cliente(buscaCpf, "", "", ""), arvoreClientes);
                        System.out.println(busca.dadosCliente());
                    } catch (Exception err) {
                        System.out.println("Cliente não encontrado!\n");
                    }
                    break;
                case 2:
                    System.out.print("CPF a ser pesquisado: ");
                    buscaCpf = in.nextLine();
                    System.out.println("O CPF informado aparece " + listaCompras.contaGasto(buscaCpf) + " vezes");
                    break;
                default:
                    break;
            }

            in.nextLine();
            limparTela();
        }
        in.close();
    }

    public static ListaCompra montaListaCompra(String nomeArquivo) throws Exception {

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

    public static ABB montaArvoreClientes(String nomeArquivo) throws Exception {
        File arquivoClientes = new File(nomeArquivo);
        Scanner leitor = new Scanner(arquivoClientes);

        String primeiraLinha = leitor.nextLine();
        Cliente clienteRaiz = getClienteFromLine(primeiraLinha);
        ABB arvoreClientes = new ABB(clienteRaiz);

        while (leitor.hasNextLine()) {
            String line = leitor.nextLine();
            Cliente cliente = getClienteFromLine(line);
            arvoreClientes.inserir(cliente, arvoreClientes);
        }

        leitor.close();
        return arvoreClientes;
    }

    public static Compra getCompraFromLine(String line) {
        String[] lParts = line.split(";");
        Compra c = new Compra(lParts[0], Integer.parseInt(lParts[1]), lParts[2], Integer.parseInt(lParts[3]));
        return c;
    }

    public static Cliente getClienteFromLine(String line) {
        String[] lParts = line.split(";");
        Cliente cl = new Cliente(lParts[0], lParts[1], lParts[2], lParts[3]);
        return cl;
    }

    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}