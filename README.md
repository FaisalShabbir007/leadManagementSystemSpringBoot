# OnTime Lead Management System

A simple **Spring Boot** application for managing customer leads with some **CRUD operations**, built with best practices for backend development.

---

## 🚀 Features

- Add, view, and delete leads
- RESTful APIs with JSON support
- MySQL database integration
- JPA/Hibernate ORM
- Global Exception Handling
- Clean code with layered architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Postman** (for API testing)

---

## 🧩 API Endpoints

| Method | Endpoint            | Description          |
|--------|---------------------|----------------------|
| POST   | `/leads`            | Create new lead      |
| GET    | `/leads`            | Get all leads        |
| DELETE | `/leads/{id}`       | Delete lead by ID    |

---

## 📦 Setup Instructions

### 🔧 Prerequisites
- Java 17
- Maven
- MySQL Server 
- IDE (like IntelliJ, VS Code)

### ⚙️ Clone & Run

```bash
git clone https://github.com/yourusername/lead-management-system.git
cd lead-management-system
```

---

### ✍️ Configure MySQL (in application.properties)
- `spring.datasource.url=jdbc:mysql://localhost:3306/lead_db`  
- `spring.datasource.username=root`  
- `spring.datasource.password=yourpassword`

---

### ▶️ Run the Project
mvn spring-boot:run

---

### 🙌 Author
Made with ❤️ by [Faisal Shabbir]




