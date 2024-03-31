package Exercício7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produto> estoque = new ArrayList<>(); // Lista de produtos em estoque
    private static Scanner scanner = new Scanner(System.in); // Scanner para entrada do usuário

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            // Exibição do menu principal
            System.out.println("\n== Menu ==\n1. Adicionar Produto\n2. Atualizar Produto\n3. Remover Produto\n4. Gerar Relatório\n5. Ordenação de Produtos\n6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            // Switch para lidar com as opções do menu
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    menuOrdenacao();
                    break;
                case 6:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Método para exibir o menu de opções de ordenação
    private static void menuOrdenacao() {
        System.out.println("\n== Opções de Ordenação ==\n1. Nome\n2. Código\n3. Quantidade\n4. Preço\n5. Voltar");
        System.out.print("Escolha uma opção de ordenação: ");
        int opcaoOrdenacao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Switch para lidar com as opções de ordenação
        switch (opcaoOrdenacao) {
            case 1:
                ordenarProdutosPorNome();
                break;
            case 2:
                ordenarProdutosPorCodigo();
                break;
            case 3:
                ordenarProdutosPorQuantidade();
                break;
            case 4:
                ordenarProdutosPorPreco();
                break;
            case 5:
                return; // Voltar para o menu principal
            default:
                System.out.println("Opção inválida!");
        }
    }

    // Método para adicionar um novo produto ao estoque
    private static void adicionarProduto() {
        System.out.print("\nDigite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        Produto novoProduto = new Produto(nome, codigo, quantidade, preco);
        estoque.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    // Método para atualizar a quantidade em estoque de um produto
    private static void atualizarProduto() {
        System.out.print("\nDigite o código do produto que deseja atualizar: ");
        int codigo = scanner.nextInt();
        Produto produto = encontrarProdutoPorCodigo(codigo);
        if (produto != null) {
            System.out.print("Digite a nova quantidade em estoque: ");
            int novaQuantidade = scanner.nextInt();
            produto.setQuantidade(novaQuantidade);
            System.out.println("Quantidade em estoque atualizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Método para remover um produto do estoque
    private static void removerProduto() {
        System.out.print("\nDigite o código do produto que deseja remover: ");
        int codigo = scanner.nextInt();
        Produto produto = encontrarProdutoPorCodigo(codigo);
        if (produto != null) {
            estoque.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Método para gerar um relatório de estoque
    private static void gerarRelatorio() {
        System.out.println("\n== Relatório de Estoque ==");
        for (Produto produto : estoque) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Quantidade em estoque: " + produto.getQuantidade());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("--------------------------");
        }
    }

    // Método para encontrar um produto pelo código
    private static Produto encontrarProdutoPorCodigo(int codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    // Métodos para ordenar os produtos por diferentes critérios

    private static void ordenarProdutosPorNome() {
        Collections.sort(estoque, Comparator.comparing(Produto::getNome));
        gerarRelatorio();
    }

    private static void ordenarProdutosPorCodigo() {
        Collections.sort(estoque, Comparator.comparing(Produto::getCodigo));
        gerarRelatorio();
    }

    private static void ordenarProdutosPorQuantidade() {
        Collections.sort(estoque, Comparator.comparing(Produto::getQuantidade));
        gerarRelatorio();
    }

    private static void ordenarProdutosPorPreco() {
        Collections.sort(estoque, Comparator.comparing(Produto::getPreco));
        gerarRelatorio();
    }
}
