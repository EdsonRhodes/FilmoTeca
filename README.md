# Filmoteca - Sistema de Gestão de Filmes 🎬🍿

**Filmoteca** é um sistema de gerenciamento de filmes onde você pode inserir filmes, consultar informações e exibir a duração de filmes em formato amigável como "X horas e Y minutos".

## Funcionalidades 🚀

- **Inserção de filmes** no banco de dados.
- **Consulta de filmes** por ID.
- **Exibição de duração** no formato "X hora(s) e Y minuto(s)".

## Tecnologias 🛠️

- **Java 11** ou superior 🖥️
- **JDBC** com **PostgreSQL** 💾
- **Java Time API** para tratar durações ⏱️

## Pré-Requisitos ⚙️

1. **Java 11** ou superior.
2. **PostgreSQL** instalado.
3. **Driver JDBC** do PostgreSQL.

## Como Rodar 💡

1. Crie o banco de dados `Filmoteca` e a tabela `filmes`:

    ```sql
    CREATE TABLE filmes (
        id SERIAL PRIMARY KEY,
        titulo TEXT NOT NULL,
        ano INT NOT NULL,
        genero TEXT NOT NULL,
        duracao TEXT NOT NULL
    );
    ```

2. Ajuste as credenciais de acesso ao banco na classe `Filme`.

3. Compile e execute o código:

    ```bash
    javac Filme.java
    java Filme
    ```

## Exemplos 📊

**Consulta ao filme:**

### Resumo:
- Você cria uma **entidade** `Filme` para representar os dados do filme no banco de dados.
- Um **repositório** é criado para facilitar o acesso ao banco.
- O **serviço** contém a lógica para salvar o filme.
- O **controlador** gerencia as requisições HTTP e chama os métodos do serviço.
- A **página HTML** contém o formulário de cadastro para inserir os dados do filme.



