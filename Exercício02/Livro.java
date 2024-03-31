package Exercício02;
/*
 * Classe Livro

 * Autor: Pedro De Oliveira Haro
 * Data: 30/03/2024
 * Descrição: Este programa representa um livro e suas informações armazenadas em um arquivo XML
 *
 */
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    // Construtor da classe Livro
    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Método para exibir informações do livro
    public void exibirInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + ano);
    }

    // Método para salvar informações do livro em um arquivo XML
    public void salvarEmArquivo() {
        try {
            // Configuração do ambiente XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc;
            File file = new File("livroLog.xml");
            Element rootElement;

            // Verifica se o arquivo XML já existe
            if (file.exists()) {
                doc = docBuilder.parse(file);
                rootElement = doc.getDocumentElement();
            } else {
                doc = docBuilder.newDocument();
                rootElement = doc.createElement("Livros");
                doc.appendChild(rootElement);
            }

            // Cria um elemento para o livro
            Element livroElement = doc.createElement("Livro");
            rootElement.appendChild(livroElement);

            // Adiciona elementos filho para título, autor e ano do livro
            Element tituloElement = doc.createElement("Titulo");
            tituloElement.appendChild(doc.createTextNode(titulo));
            livroElement.appendChild(tituloElement);

            Element autorElement = doc.createElement("Autor");
            autorElement.appendChild(doc.createTextNode(autor));
            livroElement.appendChild(autorElement);

            Element anoElement = doc.createElement("Ano");
            anoElement.appendChild(doc.createTextNode(String.valueOf(ano)));
            livroElement.appendChild(anoElement);

            // Transforma o documento XML em um arquivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter("livroLog.xml"));

            transformer.transform(source, result);

            System.out.println("Livro salvo com sucesso.");

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método estático para exibir todos os livros armazenados no arquivo XML
    public static void exibirLivrosDoArquivo() {
        try {
            // Verifica se o arquivo XML existe
            File file = new File("livroLog.xml");
            if (!file.exists()) {
                System.out.println("Nenhum livro encontrado.");
                return;
            }

            // Configuração do ambiente XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            // Obtém a lista de elementos de livro
            NodeList nodeList = doc.getElementsByTagName("Livro");

            System.out.println("Lista de Livros:");
            // Itera sobre os elementos e exibe as informações de cada livro
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);
                String titulo = element.getElementsByTagName("Titulo").item(0).getTextContent();
                String autor = element.getElementsByTagName("Autor").item(0).getTextContent();
                int ano = Integer.parseInt(element.getElementsByTagName("Ano").item(0).getTextContent());

                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
                System.out.println("Ano de publicação: " + ano);
                System.out.println("-----------------------------");
            }

        } catch (ParserConfigurationException | org.xml.sax.SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
