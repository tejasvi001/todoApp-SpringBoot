# 📝 Todo App - Spring Boot

A simple RESTful API built using Spring Boot to manage a TODO list. This application supports full CRUD operations for TODO items, including fields like `title`, `description`, `status`, and `dueDate`. Now with support for **pagination**, **sorting**, and **Swagger (OpenAPI)** documentation.

---

## 🚀 Features

- 🔍 Get all TODOs (with pagination & sorting)
- ➕ Add new TODO
- ✏️ Update existing TODO (full and partial)
- ❌ Delete a TODO by ID
- 📌 Get TODO by ID
- 📄 Auto-generated Swagger UI
- 🧪 Input validation and model mapping

---

## 📦 Tech Stack

- ☕ Java 17+
- 🌱 Spring Boot 3.x
- 🐘 MySQL (or H2 for local testing)
- 📄 Spring Data JPA
- 🔁 ModelMapper
- 🔍 Springdoc OpenAPI 3 & Swagger UI

---

## 📌 API Endpoints

| Method | Endpoint     | Description                 |
|--------|--------------|-----------------------------|
| GET    | `/todo`      | Get paginated list of TODOs |
| GET    | `/todo/{id}` | Get TODO by ID              |
| POST   | `/todo`      | Create a new TODO           |
| PUT    | `/todo/{id}` | Update a TODO (full)        |
| PATCH  | `/todo/{id}` | Update a TODO (partial)     |
| DELETE | `/todo/{id}` | Delete a TODO by ID         |

---

## 🔍 Pagination & Sorting

All list endpoints support pagination and sorting using Spring Data’s `Pageable`.

### Example Request

```http
GET /todo?page=0&size=5&sort=title,asc


