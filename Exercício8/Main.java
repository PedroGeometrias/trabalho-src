package Exercício8;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Cria um objeto Pedido para gerenciar os pedidos
        Pedido pedido = new Pedido();

        int opcao;
        do {
            // Exibe o menu de opções para o usuário
            System.out.println("----- Sistema de Pedidos de Pizza -----");
            System.out.println("1. Adicionar pizza ao pedido");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Exibir total de pedidos e valor total");
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
        // Solicita ao usuário informações sobre a pizza a ser adicionada
        System.out.println("Digite o nome da pizza: ");
        scanner.nextLine(); // Consumir a quebra de linha pendente
        String nome = scanner.nextLine();
        System.out.println("Digite o valor da pizza: ");
        double valor = scanner.nextDouble();
        System.out.println("Digite os ingredientes separados por vírgula: ");
        scanner.nextLine(); // Consumir a quebra de linha pendente
        String[] ingredientesArray = scanner.nextLine().split(",");
        
        // Adiciona a pizza ao pedido
        pedido.adicionarPizza(new Pizza(nome, valor, List.of(ingredientesArray)));
        System.out.println("Pizza adicionada ao pedido.");
    }

    private static void exibirTotal(Pedido pedido) {
        // Exibe o total de pedidos e o valor total do pedido
        System.out.println("Total de pedidos: " + pedido.contarPedidos());
        System.out.println("Total a pagar: R$ " + pedido.calcularTotal());
    }
}

