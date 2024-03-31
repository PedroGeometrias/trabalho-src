package Exercício6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Classe responsável pela gestão da agenda de contatos
public class Agenda {
    private List<Contato> contatos; // Lista de contatos
    private String arquivoContatos; // Caminho do arquivo de contatos

    // Construtor da classe Agenda
    public Agenda(String arquivoContatos) {
        this.contatos = new ArrayList<>(); // Inicializa a lista de contatos
        this.arquivoContatos = arquivoContatos; // Define o caminho do arquivo de contatos
        carregarContatos(); // Carrega os contatos do arquivo ao instanciar a agenda
    }

    // Método para adicionar um novo contato à agenda
    public void adicionarContato(Contato contato) {
        contatos.add(contato); // Adiciona o contato à lista de contatos
        salvarContatos(); // Salva os contatos no arquivo após adicionar um novo contato
    }

    // Método para buscar contatos por nome
    public List<Contato> buscarContatosPorNome(String nome) {
        List<Contato> contatosEncontrados = new ArrayList<>(); // Lista para armazenar contatos encontrados
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) { // Verifica se o nome do contato corresponde ao nome buscado
                contatosEncontrados.add(contato); // Adiciona o contato à lista de contatos encontrados
            }
        }
        return contatosEncontrados; // Retorna a lista de contatos encontrados
    }

    // Método privado para carregar os contatos do arquivo
    private void carregarContatos() {
        try {
            File arquivo = new File(arquivoContatos); // Instancia um objeto File com o caminho do arquivo de contatos
            if (!arquivo.exists()) { // Verifica se o arquivo não existe
                arquivo.createNewFile(); // Cria um novo arquivo se não existir
            }
            
            // Leitura dos contatos do arquivo
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivoContatos))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(","); // Divide a linha em partes separadas por ","
                    if (parts.length == 2) { // Verifica se a linha contém nome e telefone
                        Contato contato = new Contato(parts[0], parts[1]); // Cria um novo contato com os dados lidos
                        contatos.add(contato); // Adiciona o contato à lista de contatos
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprime informações sobre a exceção, se ocorrer
        }
    }

    // Método privado para salvar os contatos no arquivo
    private void salvarContatos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoContatos))) {
            for (Contato contato : contatos) {
                writer.write(contato.getNome() + "," + contato.getTelefone()); // Escreve o nome e telefone do contato no arquivo
                writer.newLine(); // Escreve uma nova linha após cada contato
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprime informações sobre a exceção, se ocorrer
        }
    }
}

