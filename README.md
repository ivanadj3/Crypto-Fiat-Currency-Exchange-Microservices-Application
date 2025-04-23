# Crypto Fiat Currency Exchange Microservices Application
This project follows a modular architecture using Java, Spring Boot, and Docker, and includes multiple services to simulate a secure and robust exchange system.

## Technologies Used

- **Java & Spring Boot**
- **Maven**
- **H2 In-Memory Database**
- **Eureka Server (Naming Server)**
- **Feign Clients (for service communication)**
- **Spring Cloud Gateway (API Gateway)**

## Implemented Microservices

### Core Services
- **Naming Server** (`Eureka`) – for service registration and discovery.
- **API Gateway** – central entry point, includes basic authentication and request routing.

### User Management
- **Users Service** – CRUD operations for users with role-based access (OWNER, ADMIN, USER).

### Fiat Currency System
- **Currency Exchange Service** – stores and serves exchange rates between fiat currencies.
- **Currency Conversion Service** – allows users to convert fiat currencies based on exchange rates.
- **Bank Account Service** – manages user accounts and fiat balances.

### Crypto Currency System
- **Crypto Wallet Service** – manages user wallets with cryptocurrency balances.
- **Crypto Exchange Service** – stores and serves exchange rates between cryptocurrencies.
- **Crypto Conversion Service** – allows conversion between different cryptocurrencies.

### Integration Services
- **Trade Service** – allows exchange between fiat and cryptocurrencies with intermediate conversions when necessary.
- **Transfer Service** – supports transfers between users, including fee validation and transaction summaries.

## Advanced Features

- **Feign Clients** for all inter-service communication (no RestTemplate usage except in API Gateway).
- **Exception Handling** with detailed user messages and HTTP status codes.
- **Circuit Breaker / Retry** implemented in one service for fault tolerance.
- **Rate Limiting**: Max 2 requests per 45 seconds per user to sensitive services (conversion, transfer, trade).

## Functional URLs

A complete list of functional endpoints with ports and usage examples is available in the repository under `URL.txt`.

