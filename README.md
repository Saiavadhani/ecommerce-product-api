# E-Commerce Product Management API

A RESTful backend application built using **Spring Boot** that provides CRUD operations for managing products. This project demonstrates core backend development concepts such as layered architecture, Spring Data JPA, Hibernate ORM, REST APIs, and database integration.

---

## 🚀 Features

- Create a new product
- Retrieve all products
- Retrieve a product by ID
- Update existing product details
- Delete a product
- Bulk product insertion
- Persistent storage using H2 Database
- Layered Architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring Web | REST API Development |
| Spring Data JPA | Data Access Layer |
| Hibernate | ORM Framework |
| H2 Database | In-Memory Database |
| Maven | Dependency Management & Build Tool |
| Lombok | Reduces Boilerplate Code |
| Postman | API Testing |

---

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── org.example.ecomproject
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── EcomprojectApplication.java
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
```

---

## 🏗️ Architecture

```
                Client (Postman)

                       │

                 ProductController

                       │

                 ProductService

                       │

               ProductRepository

                       │

                H2 Database
```

---

## 📌 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/` | Welcome endpoint |
| GET | `/products` | Retrieve all products |
| GET | `/product/{id}` | Retrieve product by ID |
| POST | `/product` | Add a new product |
| POST | `/products` | Add multiple products |
| PUT | `/product` | Update an existing product |
| DELETE | `/product/{id}` | Delete a product |

> **Note:** The endpoint paths shown above should match your controller mappings. Update them if your implementation uses different URLs.

---

## ⚙️ How to Run the Project

### Clone the repository

```bash
git clone https://github.com/Saiavadhani/ecommerce-product-api.git
```

### Navigate to the project

```bash
cd ecommerce-product-api
```

### Run the application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

---

## 🗄️ Database

This project currently uses the **H2 In-Memory Database** for development.

You can access the H2 Console after starting the application (if enabled in `application.properties`).

---

## 🧪 API Testing

The REST APIs were tested using **Postman**.

Example request:

```http
POST /product
Content-Type: application/json

{
    "prodName": "Laptop",
    "price": 75000,
    "description": "Gaming Laptop"
}
```

---

## 📈 Future Enhancements

This project will continue to evolve as I progress in my backend development journey.

Planned improvements include:

- Spring Security
- JWT Authentication
- Bean Validation
- Global Exception Handling
- MySQL Integration
- MongoDB Integration
- Docker
- Swagger / OpenAPI Documentation
- Logging
- Microservices Architecture
- Kafka Integration
- Cloud Deployment (AWS)

---

## 📚 Learning Outcomes

Through this project I gained hands-on experience with:

- Building RESTful APIs using Spring Boot
- Layered Architecture
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- CRUD Operations
- Maven Project Structure
- API Testing using Postman

---

## 👨‍💻 Author

**Sai Avadhani**

GitHub: https://github.com/Saiavadhani

---

### ⭐ If you found this project helpful, consider giving it a star.
