package Exercício8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Lista de pizzas disponíveis
    private static List<Pizza> pizzasDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        // Adicionando algumas pizzas disponíveis
        pizzasDisponiveis.add(new Pizza("Margarita", 25.0, Arrays.asList("Molho de tomate", "Queijo", "Manjericão"), "Média"));
        pizzasDisponiveis.add(new Pizza("Calabresa", 30.0, Arrays.asList("Molho de tomate", "Queijo", "Calabresa"), "Grande"));
        pizzasDisponiveis.add(new Pizza("Frango com Catupiry", 35.0, Arrays.asList("Molho de tomate", "Queijo", "Frango", "Catupiry"), "Família"));
        
        // Cria um Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Capturar o endereço de entrega
        System.out.print("Digite o endereço de entrega: ");
        String enderecoEntrega = scanner.nextLine();

        // Cria um objeto Pedido para gerenciar os pedidos
        Pedido pedido = new Pedido(enderecoEntrega);

        int opcao;
        do {
            // Exibe o menu de opções para o usuário
            System.out.println("----- Sistema de Pedidos de Pizza -----");
            System.out.println("1. Adicionar pizza ao pedido");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Exibir total de pedidos e valor total e media");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Lê a opção escolhida pelo usuário
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarPizza(scanner, pedido); // Adiciona uma pizza ao pedido
                    break;
                case 2:
                    pedido.cancelarPedido(); // Cancela o pedido atual
                    System.out.println("Pedido cancelado.");
                    break;
                case 3:
                    exibirTotal(pedido); // Exibe o total de pedidos e o valor total
                    System.out.println("Média: " + pedido.calcularMedia());
                    System.out.println("Endereço de entrega: " + pedido.getEnderecoEntrega());
                    break;
                case 0:
                    System.out.println("Saindo..."); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente."); // Mensagem de erro para opção inválida
            }
        } while (opcao != 0); // Repete o loop até que o usuário escolha a opção 0 (sair)

        scanner.close(); // Fecha o Scanner
    }

    private static void adicionarPizza(Scanner scanner, Pedido pedido) {
        // Exibir o menu de opções
        System.out.println("Escolha uma opção:");
        System.out.println("1. Escolher pizza existente");
        System.out.println("2. Cadastrar nova pizza");

        // Ler a opção escolhida pelo usuário
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                // Exibir o menu de pizzas disponíveis
                System.out.println("Escolha uma pizza:");
                for (int i = 0; i < pizzasDisponiveis.size(); i++) {
                    System.out.println((i + 1) + ". " + pizzasDisponiveis.get(i).getNome() + " - R$ " + pizzasDisponiveis.get(i).getValor());
                }
                System.out.print("Escolha o número da pizza: ");
                int escolha = scanner.nextInt();
                // Verificar se a escolha é válida e adicionar a pizza ao pedido
                if (escolha >= 1 && escolha <= pizzasDisponiveis.size()) {
                    Pizza pizzaEscolhida = pizzasDisponiveis.get(escolha - 1);
                    pedido.adicionarPizza(pizzaEscolhida);
                    System.out.println(pizzaEscolhida.getNome() + " adicionada ao pedido.");
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 2:
                // Cadastrar uma nova pizza
                System.out.print("Digite o nome da nova pizza: ");
                String nomePizza = scanner.next();
                System.out.print("Digite o valor da nova pizza: ");
                double valorPizza = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("Digite os ingredientes da nova pizza (separados por vírgula): ");
                String ingredientesString = scanner.nextLine();
                List<String> ingredientes = Arrays.asList(ingredientesString.split(","));
                System.out.print("Digite o tamanho da nova pizza: ");
                String tamanhoPizza = scanner.next();
                // Criar a nova pizza e adicioná-la à lista de pizzas disponíveis
                Pizza novaPizza = new Pizza(nomePizza, valorPizza, ingredientes, tamanhoPizza);
                pizzasDisponiveis.add(novaPizza);
                System.out.println("Nova pizza cadastrada com sucesso!");
                // Adicionar a nova pizza ao pedido
                pedido.adicionarPizza(novaPizza);
                System.out.println(novaPizza.getNome() + " adicionada ao pedido.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void exibirTotal(Pedido pedido) {
        // Exibe o total de pedidos e o valor total do pedido
        System.out.println("Total de pedidos: " + pedido.contarPedidos());
        System.out.println("Total a pagar: R$ " + pedido.calcularTotal());
    }


}