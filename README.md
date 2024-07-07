# Sample E-commerce Microservices Project

## Overview

Welcome to the Sample E-commerce Microservices Project! This repository contains a suite of microservices that collectively support a basic e-commerce platform. The project includes services for managing orders, inventory, products, and an API gateway for streamlined communication and integration.

## Project Components

1. **Order Service**: Handles order processing, creation, and management.
2. **Inventory Service**: Manages product inventory and stock levels.
3. **Product Service**: Manages product details and catalog.
4. **API Gateway Service**: Centralized entry point for all client requests, integrating with individual services and aggregating Swagger documentation.

## Key Features

- **Swagger Integration**: Each service includes integrated Swagger documentation for API exploration and testing.
- **Swagger Aggregation**: The API Gateway consolidates all service-specific Swagger documentation into a single, unified interface.
- **Keycloak Authentication**: Keycloak is used for authentication and authorization across services.
- **Docker Integration**: Docker is used to containerize the MySQL database and Keycloak for easy deployment and management.
- **FlywayDB for Migrations**: FlywayDB is used to manage database migrations, ensuring the schema is up-to-date.
- **OpenFeign for Inter-service Communication**: OpenFeign is utilized to simplify and streamline communication between services.
- **Spring Cloud Gateway MVC**: Provides routing and cross-cutting concerns for service integration.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Docker
- Docker Compose
- Java 17+
- Maven

### Setup and Deployment

1. **Clone the Repository**:
   ```bash
   git clone git@github.com:sumanta-ghosh/spring-boot-microservices.git
   cd sample-ecommerce-project
   
2. **Build the Services**:
	Build all microservices using Maven:
   ```bash
   mvn clean install

   
3. **Start Docker Containers**:
	Use Docker Compose to start MySQL and Keycloak containers:
   ```bash
   docker-compose up -d

   
4. **Run the Services:**:
	Start each service individually. For example, to start the Order Service:
   ```bash
	cd order-service
	mvn spring-boot:run

Repeat for the Inventory, Product, and API Gateway services.

## Access the Services

### Swagger UI:
- **Order Service**: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- **Inventory Service**: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
- **Product Service**: [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)
- **API Gateway**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Keycloak Admin Console:
- [http://localhost:8084](http://localhost:8084)

## Additional Information

- **Keycloak Configuration**: Refer to the Keycloak documentation for setting up realms, clients, and roles.
- **Database Migrations**: FlywayDB automatically applies migrations at service startup. See the `db/migration` directory in each service for details.
- **Inter-service Communication**: OpenFeign simplifies REST clients for communication between services. Check the configuration in each service's `application.yml`.

## References

This project was inspired and built using concepts and tutorials from the following YouTube playlist:
- [Microservices with Spring Boot and Spring Cloud](https://www.youtube.com/playlist?list=PLSVW22jAG8pDeU80nDzbUgr8qqzEMppi8)

## Contributions

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

For any questions or support, please open an issue or contact Sumanta.


