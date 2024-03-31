package Exercício3;
/*
 * Sistema Bancário Simples


 * Autor: Pedro De Oliveira Haro
 * Data: 30/03/2024 
 * Descrição: Este programa implementa um sistema bancário em Java
 *
 * FUNCIONAMENTO DO PROGRAMA:
 * 
 * 1. Classe ContaBancaria:
 *    - A classe "ContaBancaria" representa uma conta bancária e fornece métodos para depósito, saque, consulta de saldo, impressão de informações e salvamento de conta em arquivo.
 *    
 * 2. Arquivos Criados: 
 *    - "LOG" : Todas as transações (depósitos e saques) são registradas em um arquivo de log chamado "transaction_log.txt", 
 *    - com timestamp, número da conta, tipo de transação e valor.
	  - "Arquivos de Conta" :As informações de cada conta bancária são armazenadas em arquivos de texto separados, 
	  - com o número da conta como parte do nome do arquivo.
 *    - Cada arquivo contém o número da conta, nome do titular e saldo da conta.
 *    
 * OBSERVAÇÕES:
 *    - O acesso ao log de transações requer uma senha de administrador para garantir segurança.
 *    - Os arquivos de log e de conta são salvos no diretório do programa.
 *    
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;

    private static final String LOG_FILE = "transaction_log.txt"; // Nome do arquivo de log

    // Construtor da classe ContaBancaria
    public ContaBancaria(int numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    // Método estático para exibir o log de transações (requer senha de administrador)
    public static void exibirLog(int senha) {
        if (senha == 1234) { // Senha de administrador
            try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
                String line;
                System.out.println("=== Log do Banco ===");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("====================");
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo de log: " + e.getMessage());
            }
        } else {
            System.out.println("Senha de administrador incorreta.");
        }
    }

    // Método estático para carregar uma conta bancária a partir de um arquivo
    public static ContaBancaria carregarConta(int numeroConta) {
        try (BufferedReader reader = new BufferedReader(new FileReader("conta_" + numeroConta + ".txt"))) {
            int numConta = Integer.parseInt(reader.readLine());
            String nomeTitular = reader.readLine();
            double saldo = Double.parseDouble(reader.readLine());
            return new ContaBancaria(numConta, nomeTitular, saldo);
        } catch (IOException e) {
            System.out.println("Conta não encontrada.");
            return null;
        }
    }
    
    // Método para realizar um depósito na conta bancária
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
            logTransacao("Depósito", valor);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Método para realizar um saque na conta bancária
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
            logTransacao("Saque", valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    // Método para obter o saldo atual da conta
    public double getSaldo() {
        return saldo;
    }

    // Método para imprimir informações da conta bancária
    public void imprimirInfo() {
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Nome do Titular: " + nomeTitular);
        System.out.println("Saldo: " + saldo);
    }

    // Método para salvar as informações da conta em um arquivo
    public void salvarConta() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conta_" + numeroConta + ".txt"))) {
            writer.write(numeroConta + "\n");
            writer.write(nomeTitular + "\n");
            writer.write(saldo + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar informações da conta.");
        }
    }

    // Método privado para registrar uma transação no arquivo de log
    private void logTransacao(String transactionType, double amount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateTime.format(formatter);

            String logEntry = String.format("[%s] conta %d - %s: %.2f\n", timestamp, numeroConta, transactionType, amount);
            writer.write(logEntry);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de log de transações.");
        }
    }
}