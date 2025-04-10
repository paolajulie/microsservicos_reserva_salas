# Sistema de Reserva de Salas

Projeto desenvolvido como trabalho da disciplina de **Microserviços**, com o objetivo de aplicar os conceitos de arquitetura de microsserviços na construção de um sistema distribuído para gerenciamento de reservas de salas.

## 🧩 Arquitetura

O sistema é dividido em três microserviços principais, cada um com seu próprio banco de dados:

- **Usuários** (`usuario-service`)
- **Salas** (`salas-service`)
- **Reservas** (`reserva-service`)

Cada microserviço é responsável por uma parte específica do domínio da aplicação, seguindo o padrão de **banco de dados por serviço** e comunicação via **REST**.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- PostgreSQL
- Docker & Docker Compose
- Lombok
- JPA / Hibernate
- Adminer (para visualização dos bancos de dados)
