package Exercício8;

import java.util.List;

// Classe que representa uma pizza
class Pizza {
    private String nome;
    private double valor;
    private List<String> ingredientes;
    private String tamanho; 
    
    // Construtor da classe Pizza
    public Pizza(String nome, double valor, List<String> ingredientes, String tamanho) {
        this.nome = nome; // Inicializa o nome da pizza com o valor fornecido
        this.valor = valor; // Inicializa o valor da pizza com o valor fornecido
        this.ingredientes = ingredientes; // Inicializa a lista de ingredientes da pizza com a lista fornecida
        this.tamanho = tamanho;
    }

    // Método para o tamanho
    public String getTamanho() {
        return tamanho;
    }
    
    // Método para obter o nome da pizza
    public String getNome() {
        return nome; // Retorna o nome da pizza
    }

    // Método para obter o valor da pizza
    public double getValor() {
        return valor; // Retorna o valor da pizza
    }

    // Método para obter a lista de ingredientes da pizza
    public List<String> getIngredientes() {
        return ingredientes; // Retorna a lista de ingredientes da pizza
    }
}
