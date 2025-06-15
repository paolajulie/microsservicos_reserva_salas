# Sistema de Reserva de Salas - Arquitetura de Microserviços

Este projeto implementa um sistema de reserva de salas usando uma arquitetura de microserviços, com os seguintes componentes:

## 🏗️ Arquitetura

### Componentes Principais

1. **API Gateway (Spring Cloud Gateway)**
   - Roteamento de requisições para os microserviços
   - Configuração de CORS
   - Integração com Eureka Server

2. **Eureka Server (Spring Cloud Netflix)**
   - Registro e descoberta de serviços
   - Monitoramento de saúde dos serviços
   - Dashboard de serviços registrados

3. **Microserviços**
   - **Usuário Service**: Gerenciamento de usuários
   - **Salas Service**: Gerenciamento de salas
   - **Reserva Service**: Gerenciamento de reservas

4. **Mensageria (RabbitMQ)**
   - Comunicação assíncrona entre serviços
   - Gerenciamento de filas
   - Interface de administração

5. **Bancos de Dados**
   - PostgreSQL para cada microserviço
   - Dados persistidos em volumes Docker

## 🚀 Tecnologias Utilizadas

- **Backend**
  - Java 17
  - Spring Boot 3.2.3
  - Spring Cloud Gateway
  - Spring Cloud Netflix Eureka
  - Spring AMQP (RabbitMQ)
  - PostgreSQL
  - Maven

- **Infraestrutura**
  - Docker
  - Docker Compose

## 📋 Pré-requisitos

- Docker e Docker Compose instalados
- Java 17 (para desenvolvimento local)
- Maven (para desenvolvimento local)

## 🛠️ Como Executar

1. **Clone o repositório**
   ```bash
   git clone https://github.com/paolajulie/microsservicos_reserva_salas.git
   cd microsservicos_reserva_salas
   ```

2. **Construa e inicie os containers**
   ```bash
   docker-compose up -d --build
   ```

3. **Acesse as aplicações**
   - API Gateway: http://localhost:8080
   - Eureka Server: http://localhost:8761
   - RabbitMQ Management: http://localhost:15672
     - Usuário: guest
     - Senha: guest
   - Adminer (Gerenciamento de DB): http://localhost:8084
     - Sistema: PostgreSQL
     - Servidor: [nome-do-container-db]
     - Usuário: admin
     - Senha: admin
     - Banco: [nome-do-banco]

## 🔄 Fluxo de Dados

**Comunicação entre Serviços**
- Síncrona: Via API Gateway
  ```
  Cliente → API Gateway (/api/users) → Usuário Service
  Cliente → API Gateway (/api/rooms) → Salas Service
  Cliente → API Gateway (/api/bookings) → Reserva Service
  ```
- Assíncrona: Via RabbitMQ
  ```
  Reserva Service → RabbitMQ → Notificação Service
  ```

## 📦 Estrutura de Diretórios

```
.
├── api-gateway/             # API Gateway
├── eureka-server/           # Servidor Eureka
├── usuario-service/         # Microserviço de Usuários
├── salas-service/          # Microserviço de Salas
├── reserva-service/        # Microserviço de Reservas
├── docker-compose.yml      # Configuração Docker Compose
└── README.md
```

## 🔍 Monitoramento

- **Eureka Dashboard**: http://localhost:8761
  - Visualização de serviços registrados
  - Status de saúde dos serviços
  - Metadados dos serviços

- **RabbitMQ Management**: http://localhost:15672
  - Monitoramento de filas
  - Métricas de mensagens
  - Gerenciamento de exchanges

## 🛡️ Segurança

- CORS configurado no API Gateway
- Autenticação básica no RabbitMQ
- Volumes Docker para persistência segura
- Redes Docker isoladas por serviço

## 🔧 Desenvolvimento Local

**Backend (cada microserviço)**
```bash
cd [nome-do-serviço]
mvn spring-boot:run
```

## 📝 Notas Adicionais

- Os serviços são registrados automaticamente no Eureka
- O API Gateway roteia as requisições baseado nos paths configurados:
  - `/api/users/**` → Usuário Service
  - `/api/rooms/**` → Salas Service
  - `/api/bookings/**` → Reserva Service
- RabbitMQ gerencia a comunicação assíncrona entre serviços
- Os bancos de dados são persistidos em volumes Docker
- Cada microserviço possui seu próprio banco de dados PostgreSQL
- As redes Docker são isoladas por serviço para maior segurança
