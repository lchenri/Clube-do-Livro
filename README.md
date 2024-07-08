# Tecnologias
- Java
- Spring Boot
- Spring MVC
- Spring Security
- JSON Web Tokens - JWT
- PostgreSQL
- Java Persistence API - JPA
- SpringDoc OpenAPI3
- Lombok

# Práticas Adotadas
- SOLID, DRY
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de exceções
- Geração de documentação com o Swagger

# O que é
- Projeto que visa implementar o backend de um clube do livro, na qual terá o cadastro dos clientes, livros e as operações de vendas de livros.

# Documentação da API

A documentação completa da API pode ser acessada através da interface Swagger. Para visualizar a documentação, siga os passos abaixo:

1. [Inicie a aplicação Spring Boot](#como-executar-o-projeto).
2. Acesse o seguinte URL no seu navegador: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

# Configuração do Banco de Dados

Para configurar o banco de dados PostgreSQL, siga os passos abaixo:

1. Instale o PostgreSQL. Você pode baixar a versão mais recente [aqui](https://www.postgresql.org/download/).
2. Crie um banco de dados chamado `clubedolivro`.
   ```sql
   CREATE DATABASE clubedolivro;
   ```
3. Crie um usuário com permissões para acessar esse banco de dados.
    ```sql
    CREATE USER usuario WITH PASSWORD '1234';
    GRANT ALL PRIVILEGES ON DATABASE clubedolivro TO usuario;
    ```
4. No arquivo application.properties, configure as propriedades de conexão com o banco de dados. Deve ficar algo similar ao que está abaixo:
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/clubedolivro
    spring.datasource.username=usuario
    spring.datasource.password=1234
    ...
    ```

# Como Executar o Projeto

1. Clone o repositório: `git clone https://github.com/lchenri/Clube-do-Livro.git`
2. Navegue até o diretório do projeto: `cd Clube-do-Livro`
3. Compile e execute a aplicação: `mvn spring-boot:run`
4. Acesse a aplicação no navegador: [http://localhost:8080](http://localhost:8080)

