package com.Filmoteca.Sistema.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;

public class Filme {

    // Atributos
    private String titulo;
    private int ano;
    private String genero;
    private Duration duracao;

    // Construtor
    public Filme(String titulo, int ano, String genero, String duracao) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.duracao = Duration.parse(duracao);

        System.out.println("Inserindo Filme: " + this.titulo + ", " + this.ano + ", " + this.genero + ", " + this.duracao.toString());

    }

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Ano: " + ano);
        System.out.println("Genero: " + genero);
        System.out.println("Duracao: " + duracao);
    }

    // Método para salvar no banco de dados
    public void salvarNoBanco() {
        // Definir as credenciais do banco de dados
        String url = "jdbc:postgresql://localhost:5432/Filmoteca";
        String usuario = "postgres";
        String senha = "pi199458";

        // Comando SQL
        String sql = "INSERT INTO filmes (titulo, ano, genero, duracao) VALUES (?, ?, ?, ?)";

        // Conexão e execução do comando
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Definir os parâmetros
            stmt.setString(1, this.titulo);
            stmt.setInt(2, this.ano);
            stmt.setString(3, this.genero);
            stmt.setString(4, this.duracao.toString());


            // Executar o comando
            stmt.executeUpdate();
            System.out.println("Filme \"" + this.titulo + "\" salvo no banco de dados!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método principal
    public static void main(String[] args) {


        // Criando instâncias de Filme
        Filme filme1 = new Filme("Senhor dos Aneis", 2010, "Aventura","PT3H");
        Filme filme2 = new Filme("Matrix", 2000, "Acao","PT2H30M");
        Filme filme3 = new Filme("MIB", 2012, "Comedia", "PT2H");
        Filme filme4 = new Filme("Vingadores", 2012, "acao", "PT2H");

        // Exibir as informações dos filmes
        filme1.exibirInformacoes();
        filme2.exibirInformacoes();
        filme3.exibirInformacoes();

        // Salvar os filmes no banco de dados
        filme1.salvarNoBanco();
        filme2.salvarNoBanco();
        filme3.salvarNoBanco();
        filme4.salvarNoBanco();
    }
}
