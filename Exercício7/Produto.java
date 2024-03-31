package Exercício7;

// Classe que representa um produto
class Produto {
    // Atributos do produto
    private String nome; // Nome do produto
    private int codigo; // Código do produto
    private int quantidade; // Quantidade em estoque do produto
    private double preco; // Preço do produto

    // Construtor da classe Produto
    public Produto(String nome, int codigo, int quantidade, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Métodos para acessar os atributos do produto

    // Retorna o nome do produto
    public String getNome() {
        return nome;
    }

    // Retorna o código do produto
    public int getCodigo() {
        return codigo;
    }

    // Retorna a quantidade em estoque do produto
    public int getQuantidade() {
        return quantidade;
    }

    // Retorna o preço do produto
    public double getPreco() {
        return preco;
    }

    // Define a quantidade em estoque do produto
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
