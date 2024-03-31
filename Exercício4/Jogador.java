package Exercício4;

//Classe Jogador
class Jogador {
 private String nome;
 private int pontuacao;
 private int nivel;
 
 // Construtor
 public Jogador(String nome, int pontuacao, int nivel) {
     this.nome = nome;
     this.pontuacao = pontuacao;
     this.nivel = nivel;
 }
 
 // Métodos getters e setters
 public String getNome() {
     return nome;
 }

 public void setNome(String nome) {
     this.nome = nome;
 }

 public int getPontuacao() {
     return pontuacao;
 }

 public void setPontuacao(int pontuacao) {
     this.pontuacao = pontuacao;
 }

 public int getNivel() {
     return nivel;
 }

 public void setNivel(int nivel) {
     this.nivel = nivel;
 }

 // Método para aumentar a pontuação
 public void aumentarPontuacao(int pontos) {
     this.pontuacao += pontos;
 }

 // Método para subir de nível
 public void subirNivel() {
     this.nivel++;
 }

 // Método para exibir informações do jogador
 public void exibirInformacoes() {
     System.out.println("Nome: " + nome);
     System.out.println("Pontuação: " + pontuacao);
     System.out.println("Nível: " + nivel);
 }
}