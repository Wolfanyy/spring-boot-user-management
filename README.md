# Spring Boot User Management

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.5-green)
![Hibernate](https://img.shields.io/badge/Hibernate-6.6-brown)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.9-red)
![REST API](https://img.shields.io/badge/REST-JSON-blueviolet)

A Spring Boot CRUD application for managing users built with Spring Boot, Spring Data JPA, REST API, JavaScript, and PostgreSQL.

---

# Overview

This project is a full-stack CRUD (Create, Read, Update, Delete) application built with Spring Boot.

The backend exposes a REST API that manages users, while the frontend is implemented using HTML, CSS, and vanilla JavaScript. The application demonstrates layered architecture, DTO mapping with MapStruct, validation, centralized exception handling, and asynchronous communication using the Fetch API.

---

# Features

- Create new users
- View all users
- Update existing users
- Delete users
- RESTful API
- JSON request/response
- JavaScript Fetch API
- Bean Validation
- Email uniqueness validation
- DTO mapping using MapStruct
- Global exception handling
- Responsive user interface
- Layered architecture (Controller → Service → Repository)

---

# Technologies

## Backend

- Java 21
- Spring Boot 3
    - Spring Web
    - Spring Data JPA
- Hibernate ORM
- Jakarta Validation
- MapStruct
- Lombok
- Maven

## Frontend

- HTML5
- CSS3
- JavaScript
- Fetch API

## Database

- PostgreSQL 17

# Key Concepts

- REST API
- Layered Architecture
- Repository Pattern
- Service Layer Pattern
- DTO Pattern
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- Bean Validation
- MapStruct
- Exception Handling
- Fetch API

---

# Request Flow

```text
Browser
      │
      ▼
JavaScript (Fetch API)
      │
      ▼
REST Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
Hibernate
      │
      ▼
PostgreSQL
      ▲
      │
JSON Response
      ▲
      │
JavaScript
      ▲
      │
HTML
```

---

# Project Structure

```text
src/main/java
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── mapper
├── repository
├── service
└── util

src/main/resources
├── static
│   ├── css
│   └── js
├── templates
└── application.yml
```

---

# Screenshots

## Users List

<img width="1225" height="722" alt="Снимок экрана — 2026-06-29 в 09 50 45" src="https://github.com/user-attachments/assets/c04e4123-3038-40bb-8d33-0678a52b1203" />


## Create User

<img width="546" height="555" alt="Снимок экрана — 2026-06-29 в 09 51 41" src="https://github.com/user-attachments/assets/bcaf53c5-8008-4f43-8edc-4ec72a1f19b4" />


## Edit User

<img width="546" height="555" alt="Снимок экрана — 2026-06-29 в 09 52 01" src="https://github.com/user-attachments/assets/82b57175-5e13-4c07-b4e4-f4562e73689d" />

## Validation Errors

<img width="546" height="589" alt="Снимок экрана — 2026-06-29 в 09 52 31" src="https://github.com/user-attachments/assets/5e498e20-e437-485f-b492-b4a347e9b059" />

---

# Database Schema

```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    age INTEGER NOT NULL
);
```

---

# Getting Started

## Clone Repository

```bash
git clone https://github.com/Wolfanyy/spring-boot-user-management.git
```

## Create Database

```sql
CREATE DATABASE users_db;
```

## Configure Database

Update the datasource settings in:

```text
src/main/resources/application.yml
```

Example:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/users_db
    username: postgres
    password: your_password
```

## Run

```bash
mvn spring-boot:run
```

or

```bash
mvn clean package
java -jar target/spring-boot-user-management.jar
```

The application will be available at:

```
http://localhost:8080/users
```

---

# REST API

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/v1/users` | Get all users |
| GET | `/api/v1/users/{id}` | Get user by id |
| POST | `/api/v1/users` | Create user |
| PUT | `/api/v1/users/{id}` | Update user |
| DELETE | `/api/v1/users/{id}` | Delete user |

---

# Validation Rules

## Name

- Required
- Length between 3 and 30 characters
- Letters, spaces, and hyphens only

## Last Name

- Required
- Length between 3 and 30 characters
- Letters, spaces, and hyphens only

## Email

- Required
- Valid email format
- Must be unique

## Age

- Required
- Range from 1 to 100

---

# Error Handling

The application uses centralized exception handling with `@RestControllerAdvice`.

Handled exceptions include:

- ValidationException
- UserNotFoundException
- DuplicateEmailException
- MethodArgumentNotValidException
- Unexpected server errors

---

# Author

**Anna Gribanova**

GitHub: https://github.com/Wolfanyy
