package Exercício8;

import java.util.ArrayList;
import java.util.List;

// Classe que representa um pedido de pizzas
class Pedido {
    private List<Pizza> pizzas; // Lista de pizzas no pedido
    private String enderecoEntrega;

    // Modifique o construtor da classe Pedido para inicializar a lista de pizzas
    public Pedido(String enderecoEntrega) {
        this.pizzas = new ArrayList<>(); // Inicializa a lista de pizzas como uma ArrayList vazia
        this.enderecoEntrega = enderecoEntrega; // Define o endereço de entrega
    }
    
    // Adicionar o método getEnderecoEntrega() para retornar o endereço de entrega
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
    // Método para adicionar uma pizza ao pedido
    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza); // Adiciona a pizza à lista de pizzas do pedido
    }

    // Método para cancelar o pedido, removendo todas as pizzas
    public void cancelarPedido() {
        pizzas.clear(); // Remove todas as pizzas da lista
    }

    // Método para calcular o total do pedido
    public double calcularTotal() {
        double total = 0; // Inicializa o total como zero
        for (Pizza pizza : pizzas) { // Itera sobre todas as pizzas no pedido
            total += pizza.getValor(); // Adiciona o valor da pizza ao total
        }
        return total; // Retorna o total do pedido
    }

    // Método para contar o número de pizzas no pedido
    public int contarPedidos() {
        return pizzas.size(); // Retorna o tamanho da lista de pizzas, que representa o número de pizzas no pedido
    }
    
    // Método para calcular a média de preço dos pedidos
    public double calcularMedia() {
        if (pizzas.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Pizza pizza : pizzas) {
            soma += pizza.getValor();
        }
        return soma / pizzas.size();
    }
}
