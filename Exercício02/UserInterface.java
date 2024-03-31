package Exercício02;
/*
 * Classe UserInterface


 * Autor: Pedro De Oliveira Haro
 * Data: 30/03/2024
 * Descrição: Esta classe é responsável por fornecer a interface do usuário
 */

import java.util.Scanner;

// Classe responsável pela interface do usuário
public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja visualizar os livros armazenados? (s/n)");
        String respostaVerLivros = scanner.nextLine();
        if (respostaVerLivros.equalsIgnoreCase("s")) {
            Livro.exibirLivrosDoArquivo();
        }

        boolean continuar = false;
        System.out.println("Deseja sair do programa? (s/n)");
        String respostaContinuar = scanner.nextLine();
        if (respostaContinuar.equalsIgnoreCase("n")) {
            continuar = true;
        }
        while (continuar) {
            System.out.println("Digite o título do livro:");
            String titulo = scanner.nextLine();

            System.out.println("Digite o autor do livro:");
            String autor = scanner.nextLine();

            System.out.println("Digite o ano de publicação do livro:");
            int ano = scanner.nextInt();
            scanner.nextLine();

            // Cria um novo objeto Livro e exibe suas informações
            Livro novoLivro = new Livro(titulo, autor, ano);
            novoLivro.exibirInfo();
            // Salva o livro no arquivo XML
            novoLivro.salvarEmArquivo();

            System.out.println("Deseja adicionar mais livros? (s/n)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        scanner.close();
    }
}

