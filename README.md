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

  Requisito necessário 
### Instruções para Configuração Local ### 

1. **Criação do arquivo `application.properties`:**

   Navegue até o diretório `src/main/resources/` e crie o arquivo `application.properties` com o seguinte conteúdo:

   ```properties
   # Configuração do banco de dados PostgreSQL
   spring.datasource.url=jdbc:postgresql://localhost:5432/NomeDoBanco
   spring.datasource.username=usuarioDoBanco
   spring.datasource.password=senhaDoBanco
   spring.datasource.driver-class-name=org.postgresql.Driver

   # Configuração do Hibernate (JPA)
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true

   # Configuração do servidor
   server.port=8080

   # Configuração do Thymeleaf
   spring.thymeleaf.prefix=classpath:/templates/
   spring.thymeleaf.suffix=.html
   ```

   **Explicação dos parâmetros:**

   - **Banco de Dados PostgreSQL:**
     - `spring.datasource.url`: URL do banco de dados (ajuste para o nome do seu banco de dados).
     - `spring.datasource.username`: Usuário do banco de dados.
     - `spring.datasource.password`: Senha do banco de dados.
     - `spring.datasource.driver-class-name`: Driver necessário para a conexão com o PostgreSQL.

   - **Hibernate (JPA):**
     - `spring.jpa.hibernate.ddl-auto`: Define como o Hibernate deve gerenciar o esquema do banco de dados (use `update` para 
         atualizações automáticas).
     - `spring.jpa.properties.hibernate.dialect`: Dialeto do banco de dados (configurado para PostgreSQL).
     - `spring.jpa.show-sql`: Habilita a exibição de SQL gerado no log.
     - `spring.jpa.properties.hibernate.format_sql`: Formata o SQL para melhor leitura.

   - **Servidor:**
     - `server.port`: A porta onde o servidor irá rodar (definido como `8080`).

   - **Thymeleaf:**
     - `spring.thymeleaf.prefix`: Caminho onde o Thymeleaf irá buscar os templates HTML.
     - `spring.thymeleaf.suffix`: Sufixo dos arquivos de template (configurado para `.html`).

2. **Rodando o Projeto:**

   Após configurar o `application.properties`, execute o projeto com o Maven ou Gradle:

   - Com **Maven**:

     ```bash
     mvn spring-boot:run
     ```

   - Com **Gradle**:

     ```bash
     gradle bootRun
     ```

3. **Acessando a Aplicação:**

   O projeto estará disponível no navegador em `http://localhost:8080`.

## Exemplos 📊

**Cadastro do filme:**

### Resumo:
- Você cria uma **entidade** `Filme` para representar os dados do filme no banco de dados.
- Um **repositório** é criado para facilitar o acesso ao banco.
- O **serviço** contém a lógica para salvar o filme.
- O **controlador** gerencia as requisições HTTP e chama os métodos do serviço.
- A **página HTML** contém o formulário de cadastro para inserir os dados do filme.



