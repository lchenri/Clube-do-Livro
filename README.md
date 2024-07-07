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
- Projeto que visa implementar um projeto de uma assinatura de clube do livro, na qual terá o cadastro dos clientes, livros e as operações de vendas de livros.


# Clientes

| Id                | Chave primária                                    |
| ----------------- | ------------------------------------------------- |
| Nome              | String                                            |
| Endereço          | String                                            |
| Telefone          | String                                            |
| Livros adquiridos | Referência de chave primária da tabela dos livros |
|                   |                                                   |

# Livros

| ID        | Chave primária |
| --------- | -------------- |
| NomeLivro | String         |
| Autor     | String         |
| Editora   | String         |
|           |                |

### Casos de uso
1. O cliente deve conseguir comprar qualquer livro desde que o mesmo exista.
2. Caso não seja possível a compra do livro, o sistema deverá lançar uma Exception.
3. O cliente deve conseguir listar os livros comprados. Caso não tenha nenhum livro comprado, o sistema deverá lançar uma exception.
