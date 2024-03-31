package Exercício4;
/*
 * Classe Main 

 * Autor: Pedro De Oliveira Haro
 * Data: 30/03/2024
 * Descrição: aqui estou implementando os sistema de jogadores usando uma stack
 *
 */
import java.util.Scanner;
import java.util.Stack;

//Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Jogador> jogadores = new Stack<>();

        boolean continuar = true; // Variável para controlar se o programa deve continuar

        while (continuar) { // Loop principal
            // Introdução e instruções
            System.out.println("\nBem-vindo ao Gerenciador de Jogadores!");
            System.out.println("Por favor, siga as instruções abaixo:");

            // Menu principal
            System.out.println("\nOpções disponíveis:");
            System.out.println("1. Adicionar jogador");
            System.out.println("2. Atualizar dados de jogador");
            System.out.println("3. Remover jogador");
            System.out.println("4. Exibir todos os jogadores");
            System.out.println("5. Ver status de jogador");
            System.out.println("6. Sair");

            System.out.println("\nSelecione uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    System.out.println("\nAdicionar jogador selecionado.");
                    Jogador novoJogador = criarNovoJogador(scanner);
                    jogadores.push(novoJogador);
                    System.out.println("\nJogador adicionado com sucesso:");
                    novoJogador.exibirInformacoes();
                    break;
                case 2:
                    System.out.println("\nAtualizar dados de jogador selecionado.");
                    if (!jogadores.isEmpty()) {
                        exibirJogadores(jogadores);
                        int jogadorIndex = selecionarJogador(scanner, jogadores.size());
                        if (jogadorIndex != -1) {
                            Jogador jogadorAtualizar = jogadores.get(jogadorIndex);
                            atualizarDadosJogador(jogadorAtualizar, scanner);
                        }
                    } else {
                        System.out.println("Não há jogadores para atualizar.");
                    }
                    break;
                case 3:
                    System.out.println("\nRemover jogador selecionado.");
                    if (!jogadores.isEmpty()) {
                        exibirJogadores(jogadores);
                        int jogadorIndex = selecionarJogador(scanner, jogadores.size());
                        if (jogadorIndex != -1) {
                            Jogador removido = jogadores.remove(jogadorIndex);
                            System.out.println("Jogador removido:");
                            removido.exibirInformacoes();
                        }
                    } else {
                        System.out.println("Não há jogadores para remover.");
                    }
                    break;
                case 4:
                    System.out.println("\nExibir todos os jogadores:");
                    if (!jogadores.isEmpty()) {
                        exibirJogadores(jogadores);
                    } else {
                        System.out.println("Não há jogadores cadastrados.");
                    }
                    break;
                case 5:
                    System.out.println("\nVer status de jogador selecionado.");
                    if (!jogadores.isEmpty()) {
                        exibirJogadores(jogadores);
                        int jogadorIndex = selecionarJogador(scanner, jogadores.size());
                        if (jogadorIndex != -1) {
                            Jogador jogadorStatus = jogadores.get(jogadorIndex);
                            System.out.println("\nStatus do jogador:");
                            jogadorStatus.exibirInformacoes();
                        }
                    } else {
                        System.out.println("Não há jogadores cadastrados.");
                    }
                    break;
                case 6:
                    System.out.println("\nSaindo do programa.");
                    continuar = false; // Define a variável continuar como false para sair do loop principal
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, selecione uma opção válida.");
                    break;
            }
        }

        // Fechar o scanner antes de sair do programa
        scanner.close();
    }

    // Método para criar um novo jogador
    public static Jogador criarNovoJogador(Scanner scanner) {
        System.out.println("Digite o nome do jogador:");
        String nome = scanner.nextLine();
        System.out.println("Digite a pontuação inicial do jogador:");
        int pontuacao = scanner.nextInt();
        System.out.println("Digite o nível inicial do jogador:");
        int nivel = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada
        return new Jogador(nome, pontuacao, nivel);
    }

    // Método para exibir os jogadores
    public static void exibirJogadores(Stack<Jogador> jogadores) {
        System.out.println("\nLista de jogadores:");
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println((i + 1) + ". " + jogadores.get(i).getNome());
        }
    }

    // Método para selecionar jogador
    public static int selecionarJogador(Scanner scanner, int totalJogadores) {
        System.out.println("\nSelecione o jogador:");
        try {
            int jogadorIndex = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada
            if (jogadorIndex < 1 || jogadorIndex > totalJogadores) {
                System.out.println("Número de jogador inválido.");
                return -1;
            }
            return jogadorIndex - 1;
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
            scanner.nextLine(); // Limpar o buffer de entrada
            return -1;
        }
    }

    // Método para atualizar dados do jogador
    public static void atualizarDadosJogador(Jogador jogador, Scanner scanner) {
        System.out.println("Selecione o que deseja atualizar:");
        System.out.println("1. Nome");
        System.out.println("2. Pontuação");
        System.out.println("3. Nível");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome do jogador:");
                    String novoNome = scanner.nextLine();
                    jogador.setNome(novoNome);
                    System.out.println("Nome atualizado com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite a nova pontuação do jogador:");
                    int novaPontuacao = scanner.nextInt();
                    jogador.setPontuacao(novaPontuacao);
                    System.out.println("Pontuação atualizada com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o novo nível do jogador:");
                    int novoNivel = scanner.nextInt();
                    jogador.setNivel(novoNivel);
                    System.out.println("Nível atualizado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler entrada.");
            scanner.nextLine(); // Limpar o buffer de entrada
        }
    }
}
