package Exercício5;
/*
 * Classe Carro
 * Autor: Pedro De Oliveira Haro
 * Data: 30/03/2024
 * Descrição: esse programa ée um simulaodor de carro via texto
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    // Construtor da classe Carro
    public Carro(String marca, String modelo, int ano, String placa, int velocidadeAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = velocidadeAtual;
    }

    // Método para acelerar o carro
    public void acelerar(int incremento) {
        velocidadeAtual += incremento;
        System.out.println("Você acelerou o carro. Nova velocidade: " + velocidadeAtual + " km/h");
    }

    // Método para frear o carro
    public void frear(int decremento) {
        velocidadeAtual -= decremento;
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
        System.out.println("Você freou o carro. Nova velocidade: " + velocidadeAtual + " km/h");
    }

    // Método para exibir informações do carro
    public void exibirInformacoes() {
        System.out.println("\nDetalhes do Carro:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Velocidade Atual: " + velocidadeAtual + " km/h");
    }

    // Método estático para criar um novo carro
    public static Carro criarNovoCarro(Scanner scanner) {
        System.out.println("\nAdicionando um novo carro:");
        System.out.println("Digite a marca do carro:");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo do carro:");
        String modelo = scanner.nextLine();
        System.out.println("Digite o ano do carro:");
        int ano = readInt(scanner);
        System.out.println("Digite a placa do carro:");
        String placa = scanner.nextLine();
        System.out.println("Digite a velocidade atual do carro:");
        int velocidadeAtual = readInt(scanner);

        return new Carro(marca, modelo, ano, placa, velocidadeAtual);
    }

    // Método auxiliar para ler um número inteiro
    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Carro> carros = new ArrayList<>();

        while (true) {
            System.out.println("\n*** Bem-vindo ao simulador de carros ***");
            System.out.println("O que você deseja fazer?");
            System.out.println("1. Adicionar um novo carro");
            System.out.println("2. Selecionar um carro existente");
            System.out.println("3. Sair");

            int opcao = readInt(scanner);

            if (opcao == 3) {
                System.out.println("Saindo do simulador de carros...");
                break;
            }

            switch (opcao) {
                case 1:
                    Carro novoCarro = criarNovoCarro(scanner);
                    carros.add(novoCarro);
                    System.out.println("Carro adicionado com sucesso!");
                    break;
                case 2:
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro adicionado ainda. Por favor, adicione um carro primeiro.");
                    } else {
                        System.out.println("Carros disponíveis:");
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.println((i + 1) + ". " + carros.get(i).marca + " " + carros.get(i).modelo);
                        }
                        System.out.println("Selecione o número do carro:");
                        int carroSelecionado = readInt(scanner);
                        if (carroSelecionado > 0 && carroSelecionado <= carros.size()) {
                            Carro carroAtual = carros.get(carroSelecionado - 1);
                            interagirComCarro(carroAtual, scanner);
                        } else {
                            System.out.println("Número de carro inválido.");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }

        scanner.close();
    }

    // Método para interagir com um carro selecionado
    public static void interagirComCarro(Carro carro, Scanner scanner) {
        while (true) {
            System.out.println("\nO que você deseja fazer com o carro?");
            System.out.println("1. Acelerar");
            System.out.println("2. Frear");
            System.out.println("3. Exibir informações do carro");
            System.out.println("4. Voltar ao menu principal");

            int escolha = readInt(scanner);

            switch (escolha) {
                case 1:
                    System.out.println("Digite a quantidade de aceleração:");
                    int aceleracao = readInt(scanner);
                    carro.acelerar(aceleracao);
                    break;
                case 2:
                    System.out.println("Digite a quantidade de desaceleração:");
                    int desaceleracao = readInt(scanner);
                    carro.frear(desaceleracao);
                    break;
                case 3:
                    carro.exibirInformacoes();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}
