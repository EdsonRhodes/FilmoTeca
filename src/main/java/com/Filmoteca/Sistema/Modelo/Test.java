package com.Filmoteca.Sistema.Modelo;

import java.sql.*;
import java.time.Duration;

public class Test {

    // Atributos
    private Duration duracao;

    // Construtor
    public Test(Duration duracao) {

        this.duracao = duracao;

        System.out.println("Inserindo Filme: " + this.duracao);
    }

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("Duracao: " + duracao);
    }

    // Método para salvar no banco de dados
    public void salvarNoBanco() {
        // Definir as credenciais do banco de dados
        String url = "jdbc:postgresql://localhost:5432/Filmoteca";
        String usuario = "postgres";
        String senha = "pi199458";

        // Comando SQL
        String sql = "INSERT INTO filmes (duracao) VALUES (?)";

        // Conexão e execução do comando
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Definir os parâmetros

            // Convertendo Duration para o formato INTERVAL
            String duracaoString = String.format("INTERVAL '%d hours %d minutes'", duracao.toHours(), duracao.toMinutesPart());

            // Usando setObject() para passar a string como INTERVAL
            stmt.setObject(1,this.duracao, Types.OTHER);

            // Executar o comando
            stmt.executeUpdate();
            System.out.println(duracao + "salvo com sucesso.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método principal
    public static void main(String[] args) {

        // Criando instâncias de Filme
        Test filme1 = new Test(Duration.ofHours(2).plusMinutes(30));



        // Salvar os filmes no banco de dados
        filme1.salvarNoBanco();

    }
}
