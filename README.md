# 🎓 Projeto: Workshop Spring Boot & NoSQL MongoDB

## Visão Geral do Projeto
Este projeto é uma API RESTful completa desenvolvida com **Spring Boot 3** e **MongoDB**, focada em um sistema de postagens de rede social. 
O objetivo principal foi consolidar conhecimentos em bancos de dados NoSQL, explorando a transição do paradigma relacional para o orientado a agregados, no caso o mongoDB, o qual é orientado a documentos.

Este é um projeto prático desenvolvido como projeto de estudo, seguindo padrões de arquitetura em camadas e boas práticas de modelagem de domínio voltada a documentos.

---

## 🎯 Objetivos do Projeto
* Compreender as principais diferenças entre o paradigma orientado a documentos e relacional.
* Implementar operações de **CRUD** completas.
* Refletir sobre decisões de design, como o uso de objetos aninhados e referenciados.
* Implementar associações entre objetos (DBRef e inclusão como atributo).
* Realizar consultas avançadas utilizando **Query Methods** e a anotação **@Query**.

---

## 📖 Principais Conceitos Aplicados

### Modelagem de Domínio NoSQL
* **Documentos e Coleções**: Uso de `@Document` e `@Id` para mapear coleções no MongoDB.
* **Associações Estratégicas**:
    * **Objetos Aninhados**: Uso de DTOs para carregar dados de forma simples e otimizada (ex: AuthorDTO e CommentDTO).
    * **Referências**: Uso de `@DBRef` com `lazy = true` para relacionar Posts a Usuários.
* **Padrão DTO (Data Transfer Object)**: Utilizado para otimizar o tráfego de dados e proteger informações sensíveis.

### Arquitetura em Camadas
O projeto segue o padrão de arquitetura organizada em três camadas principais:
* **Resources (Controllers)**: Exposição dos endpoints REST.
* **Services**: Camada de regras de negócio e controle transacional.
* **Repositories**: Camada de acesso a dados com Spring Data MongoDB.
* **Domain**: Camada contendo as entidades de domínio.

---

## 🛠️ Tecnologias Utilizadas

| Categoria | Tecnologia | Detalhe |
| :--- | :--- | :--- |
| Framework | **Spring Boot** | Desenvolvimento rápido de APIs REST. |
| Linguagem | **Java** | Linguagem base do projeto. |
| Banco de Dados | **MongoDB** | Banco de dados NoSQL orientado a documentos. |
| Persistência | **Spring Data MongoDB** | Abstração para operações no MongoDB. |
| Ferramenta BD | **MongoDB Compass** | Interface para gestão dos dados. |
| Testes | **Postman** | Utilizado para validar os endpoints da API. |

---

## ⚙️ Como Executar a API Localmente

1. **Pré-requisitos**: Certifique-se de ter o **JDK** e o **Maven** instalados, além do **MongoDB** rodando localmente.
2. **Configuração**: Em `application.properties`, configure a URI de conexão:  
   `spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo`.
3. **Carga Inicial**: O projeto possui uma classe de configuração `Instantiation` que popula o banco automaticamente com dados de teste ao iniciar.
4. **Execução**: Execute a classe principal da aplicação e acesse os endpoints via `http://localhost:8080`.

---

## 🛡️ Tratamento de Exceções
O projeto utiliza um `ResourceExceptionHandler` (via `@ControllerAdvice`) para interceptar exceções e retornar respostas HTTP padronizadas:
* **ObjectNotFoundException**: Retorna status **404 Not Found** quando um recurso não é encontrado por ID.

---

## 🔗 Endpoints Principais

| Recurso | Método | URI | Ação |
| :--- | :--- | :--- | :--- |
| **User** | GET | `/users` | Listar todos os usuários. |
| **User** | POST | `/users` | Inserir um novo usuário. |
| **User** | DELETE | `/users/{id}` | Remover usuário. |
| **User** | GET | `/users/{id}/posts` | Retornar os posts de um usuário. |
| **Post** | GET | `/posts/{id}` | Buscar post por ID. |
| **Post** | GET | `/posts/titlesearch` | Busca simples por título. |
| **Post** | GET | `/posts/fullsearch` | Busca avançada com múltiplos critérios. |

---
