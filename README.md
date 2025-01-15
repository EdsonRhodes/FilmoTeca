# Filmoteca - Sistema de Gestão de Filmes 🎬🍿

**Filmoteca** é um sistema de gerenciamento de filmes onde você pode inserir filmes, consultar informações e exibir a duração de filmes em formato amigável como "X horas e Y minutos".

## Funcionalidades 🚀

- **Inserção de filmes** no banco de dados.
- **Consulta de filmes** por ID.
- **Exibição de duração** no formato "X hora(s) e Y minuto(s)".

## Tecnologias 🛠️

- **Java 11** ou superior 🖥️
- **JDBC** com **PostgreSQL** 💾


## Pré-Requisitos ⚙️

1. **Java 11** ou superior.
2. **PostgreSQL** instalado.
3. **Driver JDBC** do PostgreSQL.

## Como Rodar 💡

1. Crie o banco de dados `Filmoteca` e a tabela `filmes`:

    ```sql
    CREATE TABLE filme (
       id SERIAL PRIMARY KEY,
       nome VARCHAR(100),
       genero VARCHAR(50),
       ano INTEGER,
       duracao INTEGER
    );
    ```

2. Ajuste as credenciais de acesso ao banco na classe `Filme`.

3. Abrir o Projeto no IntelliJ IDE
   
Selecione Open e navegue até a pasta do repositório que você acabou de clonar.
Clique em OK.

4. Rodando o Projeto
Após abrir o projeto no IntelliJ, clique no botão Run no canto superior direito ou use o atalho Shift + F10.
O IntelliJ compilará e executará automaticamente o código.
após rodar o servidor, você poderá acessar o projeto no navegador em http://localhost:8080.

## Exemplos 📊

**Consulta ao filme:**

### Resumo:
- Você cria uma **entidade** `Filme` para representar os dados do filme no banco de dados.
- Um **repositório** é criado para facilitar o acesso ao banco.
- O **serviço** contém a lógica para salvar o filme.
- O **controlador** gerencia as requisições HTTP e chama os métodos do serviço.
- A **página HTML** contém o formulário de cadastro para inserir os dados do filme.



