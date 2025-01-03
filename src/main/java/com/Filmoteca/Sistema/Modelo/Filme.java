package com.Filmoteca.Sistema.Modelo;

import java.sql.*;
import java.time.Duration;

public class Filme {

    // Atributos
    private String titulo;
    private int ano;
    private String genero;
    private Duration duracao;

    // Construtor
    public Filme(String titulo, int ano, String genero, Duration duracao) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.duracao = duracao;

        System.out.println("Inserindo Filme: " + this.titulo + ", " + this.ano + ", " + this.genero + ", " + this.duracao);
    }

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Ano: " + ano);
        System.out.println("Genero: " + genero);
        System.out.println("Duração: " + duracao);
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

            // Convertendo Duration para o formato INTERVAL
            String duracaoString = String.format("INTERVAL '%d hours %d minutes'", duracao.toHours(), duracao.toMinutesPart());

            // Usando setObject() para passar a string como INTERVAL
            stmt.setObject(4, this.duracao, Types.OTHER);

            // Executar o comando
            stmt.executeUpdate();
            System.out.println("Filme \"" + titulo + "\" salvo com sucesso.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método principal
    public static void main(String[] args) {

        // Criando instâncias de Filme
        Filme filme1 = new Filme("Senhor dos Aneis", 2010, "Aventura", Duration.ofHours(2).plusMinutes(30));
        Filme filme2 = new Filme("Matrix", 2000, "Acao", Duration.ofHours(1).plusMinutes(30));
        Filme filme3 = new Filme("MIB", 2012, "Comedia", Duration.ofHours(1).plusMinutes(25));
        Filme filme4 = new Filme("Vingadores", 2012, "acao", Duration.ofHours(1).plusMinutes(12));

        // Exibir as informações dos filmes
        filme1.exibirInformacoes();
        filme2.exibirInformacoes();
        filme3.exibirInformacoes();
        filme4.exibirInformacoes();

        // Salvar os filmes no banco de dados
        filme1.salvarNoBanco();
        filme2.salvarNoBanco();
        filme3.salvarNoBanco();
        filme4.salvarNoBanco();
    }
}
