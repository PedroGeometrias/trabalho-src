package Exercício01;

import java.util.Scanner;

// Classe responsável pela interface do usuário
public class InterfaceUsuario {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char continuar = 's';
        while (continuar == 's' || continuar == 'S') {
            // Exibe as opções para o usuário
            System.out.println("Qual operação você quer usar?");
            System.out.println("% ou / : divisão");
            System.out.println("* : multiplicação");
            System.out.println("- : subtração");
            System.out.println("+ : soma");
            // Solicita ao usuário a escolha da operação
            char sinal = scan.next().charAt(0);
            // Solicita ao usuário os valores para a operação
            System.out.println("Digite dois valores:");
            double valor1 = scan.nextDouble();
            double valor2 = scan.nextDouble();
            // Realiza a operação com base na escolha do usuário e exibe o resultado
            switch (sinal) {
                case '%':
                case '/':
                    System.out.println(Calculadora.dividir(valor1, valor2));
                    break;
                case '*':
                    System.out.println(Calculadora.multiplicar(valor1, valor2));
                    break;
                case '-':
                    System.out.println(Calculadora.subtrair(valor1, valor2));
                    break;
                case '+':
                    System.out.println(Calculadora.adicionar(valor1, valor2));
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
            // Pergunta ao usuário se deseja continuar
            System.out.println("Deseja continuar (s/n)?");
            continuar = scan.next().charAt(0);
        }
        // Encerra a calculadora
        System.out.println("Calculadora encerrada.");
        scan.close();
    }
}
