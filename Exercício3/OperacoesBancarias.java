package Exercício3;
/*
 * UI do meu "Banco"

 * Autor: Pedro De Oliveira Haro
 * Data: 30/03/2024 
 * Descrição: este programa é a interface do usuário
 * 
 * FUNCIONAMENTO DO PROGRAMA:
 * 
 * MÉTODO MAIN:
 * - Onde toda a lógica ocorre, usando um switch and case simples e chamando a ContaBancaria
 */
import java.util.Scanner;

public class OperacoesBancarias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema bancário.");

        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); 

        ContaBancaria conta = ContaBancaria.carregarConta(numeroConta);

        // Caso conta não exista, uma nova conta ée criada
        if (conta == null) {
            System.out.println("Criando nova conta.");
            System.out.print("Digite o nome do titular: ");
            String nomeTitular = scanner.nextLine();

            System.out.print("Digite o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            conta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
        }

        // UI basica
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Ver log de transacoes, senha de adm necessaria");
            System.out.println("5. Salvar e sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                	System.out.println("Digite a senha de amd:");
                	int senha = scanner.nextInt();
                    ContaBancaria.exibirLog(senha);
                    break;
                case 5:
                    conta.salvarConta();
                    System.out.println("Mudanças realizadas com sucesso");
                    scanner.close();
                    System.exit(0);
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
