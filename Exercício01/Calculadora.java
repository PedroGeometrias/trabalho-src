package Exercício01;


// Classe responsável por realizar operações matemáticas
public class Calculadora{

    // Método que retorna a soma
    public static double adicionar(double num1, double num2) {
        return num1 + num2;
    }

    // Método que retorna a subtração
    public static double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    // Método que retorna o produto
    public static double multiplicar(double fator1, double fator2) {
        return fator1 * fator2;
    }

    // Método que retorna o quociente e o resto
    public static String dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            return "Erro: Divisão por zero não é permitida.";
        } else {
            double quociente = dividendo / divisor;
            double resto = dividendo % divisor;
            return "Quociente: " + quociente + ", Resto: " + resto;
        }
    }
}
