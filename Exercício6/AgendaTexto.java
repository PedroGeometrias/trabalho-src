package Exercício6;

import java.util.List;
import java.util.Scanner;

// Classe responsável pela interação com o usuário via linha de comando para gerenciar a agenda de contatos
public class AgendaTexto {
    private Agenda agenda; // Instância da classe Agenda para manipulação dos contatos

    // Construtor da classe AgendaTexto
    public AgendaTexto(String arquivoContatos) {
        this.agenda = new Agenda(arquivoContatos); // Inicializa a agenda com o arquivo de contatos especificado
    }

    // Método para adicionar um novo contato à agenda
    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone); // Cria um novo objeto Contato com os dados fornecidos
        agenda.adicionarContato(contato); // Adiciona o contato à agenda
        System.out.println("Contato adicionado com sucesso!"); // Exibe uma mensagem de sucesso
    }

    // Método para buscar contatos por nome
    public void buscarContatosPorNome(String nome) {
        List<Contato> contatosEncontrados = agenda.buscarContatosPorNome(nome); // Busca contatos com o nome especificado na agenda
        if (contatosEncontrados.isEmpty()) { // Verifica se nenhum contato foi encontrado
            System.out.println("Nenhum contato encontrado com esse nome."); // Exibe uma mensagem informando que nenhum contato foi encontrado
        } else {
            System.out.println("Contatos encontrados com o nome '" + nome + "':"); // Exibe uma mensagem informando que contatos foram encontrados
            for (Contato contato : contatosEncontrados) {
                System.out.println(contato); // Exibe os contatos encontrados
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        String arquivoContatos = "contatos.txt"; // Nome do arquivo de contatos
        AgendaTexto agendaTexto = new AgendaTexto(arquivoContatos); // Cria uma instância da classe AgendaTexto
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler entrada do usuário

        while (true) {
            System.out.println("\nMenu:"); // Exibe o menu de opções
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato por Nome");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt(); // Lê a opção selecionada pelo usuário
            scanner.nextLine(); // Consumir o caractere de nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nome = scanner.nextLine(); // Lê o nome do contato
                    System.out.print("Telefone do contato: ");
                    String telefone = scanner.nextLine(); // Lê o telefone do contato
                    agendaTexto.adicionarContato(nome, telefone); // Chama o método para adicionar o contato à agenda
                    break;
                case 2:
                    System.out.print("Digite o nome a ser buscado: ");
                    String nomeBusca = scanner.nextLine(); // Lê o nome a ser buscado na agenda
                    agendaTexto.buscarContatosPorNome(nomeBusca); // Chama o método para buscar contatos por nome
                    break;
                case 3:
                    System.out.println("Saindo..."); // Exibe mensagem de saída
                    scanner.close(); // Fecha o scanner
                    System.exit(0); // Encerra o programa
                default:
                    System.out.println("Opção inválida."); // Exibe uma mensagem de opção inválida
            }
        }
    }
}
