package Exercício6;

// Definição da classe Contato
class Contato {
    // Atributos da classe
    private String nome; // Nome do contato
    private String telefone; // Número de telefone do contato

    // Construtor da classe Contato
    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Método para obter o nome do contato
    public String getNome() {
        return nome;
    }

    // Método para definir o nome do contato
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter o telefone do contato
    public String getTelefone() {
        return telefone;
    }

    // Método para definir o telefone do contato
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método para retornar uma representação em string do objeto Contato
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}
