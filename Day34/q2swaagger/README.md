# Product Management API with Springdoc OpenAPI

This project provides a skeleton Spring Boot REST API for managing products, with integrated API documentation using Springdoc OpenAPI (Swagger UI).

## Task Goal

The primary goal of this hands-on task is to build a simple Product Management API and then integrate Springdoc OpenAPI to generate interactive API documentation. You will complete the REST endpoint implementations and enhance their documentation.

## Technology Stack

*   **Language**: Java 17+
*   **Framework**: Spring Boot 3.2.x
*   **Build Tool**: Maven
*   **API Documentation**: Springdoc OpenAPI v2.4.x
*   **Utility**: Lombok (for boilerplate reduction)

## Project Structure

*   `src/main/java/com/example/productmanagement/ProductManagementApplication.java`: Main Spring Boot application class.
*   `src/main/java/com/example/productmanagement/model/Product.java`: Data model for a product.
*   `src/main/java/com/example/productmanagement/controller/ProductController.java`: REST controller exposing product management endpoints. **Contains TODOs.**
*   `src/main/java/com/example/productmanagement/config/OpenApiConfig.java`: Configuration for custom OpenAPI/Swagger UI details.
*   `src/main/resources/application.properties`: Application configuration.
*   `pom.xml`: Maven build configuration and dependency management.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 17 or higher
*   Maven 3.6.x or higher

### Build and Run

1.  **Clone the Repository** (or create the files from the provided structure).
2.  **Navigate to the project root directory** (where `pom.xml` is located) in your terminal.
3.  **Build the project using Maven:**
    ```bash
    mvn clean install
    ```
4.  **Run the Spring Boot application:**
    ```bash
    mvn spring-boot:run
    ```
    Alternatively, you can run the generated JAR:
    ```bash
    java -jar target/product-management-api-0.0.1-SNAPSHOT.jar
    ```

The application will start on `http://localhost:8080`.

## Accessing API Documentation

Once the application is running, open your web browser and navigate to:

*   **Swagger UI**: `http://localhost:8080/swagger-ui.html`
    *   This provides an interactive UI to explore and test your API endpoints.
*   **Raw OpenAPI JSON**: `http://localhost:8080/v3/api-docs`
    *   This provides the raw JSON definition of your API.
*   **Raw OpenAPI YAML**: `http://localhost:8080/v3/api-docs.yaml`
    *   This provides the raw YAML definition of your API.

## Your Task

Your main task is to complete the `// TODO:` sections within the `ProductController.java` file. You will need to implement the actual business logic for:

*   Retrieving all products.
*   Retrieving a product by its ID.
*   Creating a new product.
*   Updating an existing product.
*   Deleting a product by its ID.

Ensure that your implementations correctly interact with the in-memory `List<Product>` and handle edge cases (e.g., product not found) with appropriate HTTP status codes.

Good luck!
