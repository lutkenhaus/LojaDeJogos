import java.io.*;
import java.util.Scanner;

import Entidades.*;
import Estruturas.*;

class App {

    public static void main(String[] args) throws Exception {
        // Carrega estruturas
        ABB arvoreClientes = montaArvoreClientes("dados2ClientesJogos2021-2.txt");
        montaListaCompra("dados2Compras2021-2.txt", arvoreClientes);

        TabHashJogoId tabelaJogosId = montaTabelaHashJogosId("dados2JogosGames2021-2.txt");
        TabHashJogoLancamento tabelaJogosLancamento = montaTabelaHashJogosLancamento("dados2JogosGames2021-2.txt");
        
        Scanner in = new Scanner(System.in);
        String buscaCpf, buscaAnoLancamento;
        int opc = 54, ok = 0;
        
        limparTela();

        // Menu
		while (opc != 0) {
			System.out.println("/ Loja de Jogos /");
			System.out.println("(1) Totalizar gastos");
            System.out.println("(2) Buscar jogos por ano de lançamento");
			System.out.println("(0) Para sair");
			System.out.printf("\nDigite a opção desejada: ");
			do {
				opc = Integer.parseInt(in.nextLine());
				if (opc >= 0 && opc <= 2) {
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
                        System.out.println(busca.dadosCliente(tabelaJogosId));
                    } catch (Exception err) {
                        System.out.println("Cliente não encontrado!\n");
                    }
                    break;
                case 2:
                    System.out.print("Ano: ");
                    buscaAnoLancamento = in.nextLine();
                    ListaEncadeada listaJogos = tabelaJogosLancamento.buscar(new Jogo(0, "", "", buscaAnoLancamento, 0.0));
                    listaJogos.imprimir();
                    break;
                default:
                    break;
            }

            if (opc != 0) in.nextLine();
            limparTela();
        }
        in.close();
    }

    public static void montaListaCompra(String nomeArquivo, ABB arvoreClientes) throws Exception {

        File arquivoCompra = new File(nomeArquivo);
        Scanner leitor = new Scanner(arquivoCompra);

        while (leitor.hasNextLine()) {
            String line = leitor.nextLine();
            Compra compra = getCompraFromLine(line);

            // Insere a compra na lista de compras do cliente
            try {
                Cliente busca = arvoreClientes.buscaCliente(new Cliente(compra.getCpf(), "", "", ""), arvoreClientes);
                busca.getlistaCompras().adicionarInicio(compra);
            } catch (Exception err) {}
            
        }

        leitor.close();
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

    public static TabHashJogoId montaTabelaHashJogosId(String nomeArquivo) throws Exception {
        File arquivoJogos = new File(nomeArquivo);
        Scanner leitor = new Scanner(arquivoJogos);
        TabHashJogoId tabelaJogos = new TabHashJogoId(500);

        while (leitor.hasNextLine()) {
            String line = leitor.nextLine();
            Jogo jogo = getJogoFromLine(line);
            tabelaJogos.inserir(jogo);
        }

        leitor.close();
        return tabelaJogos;
    }

    public static TabHashJogoLancamento montaTabelaHashJogosLancamento(String nomeArquivo) throws Exception {
        File arquivoJogos = new File(nomeArquivo);
        Scanner leitor = new Scanner(arquivoJogos);
        TabHashJogoLancamento tabelaJogos = new TabHashJogoLancamento(500);

        while (leitor.hasNextLine()) {
            String line = leitor.nextLine();
            Jogo jogo = getJogoFromLine(line);
            tabelaJogos.inserir(jogo);
        }

        leitor.close();
        return tabelaJogos;
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

    public static Jogo getJogoFromLine(String line) {
        String[] lParts = line.split(";");
        Jogo j = new Jogo(Integer.parseInt(lParts[0]), lParts[1], lParts[2], lParts[3], Double.parseDouble(lParts[4].replace(",",".")));
        return j;
    }

    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}