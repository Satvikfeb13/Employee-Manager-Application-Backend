# 🖥️ Employee Manager Backend (Spring Boot)

This is the backend API for the **Employee Manager Application**, built using **Spring Boot**. It provides RESTful endpoints to manage employee data.

---

## 🚀 Features

- CRUD operations for Employees
- Spring Data JPA with MySQL
- CORS support to connect with Angular frontend
- Exception handling for invalid requests

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- RESTful APIs
- MySQL
- Maven

---

## 📦 Installation

### Prerequisites

- JDK 17+
- Maven

### Steps

```bash
# Clone the repository
git clone https://github.com/yourusername/employee-manager-backend.git
cd employee-manager-backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

File Structure
employee-manager-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/employeemanager/
│   │   │       ├── controller/            # Contains REST controllers
│   │   │       │   └── EmployeeController.java
│   │   │       ├── model/                 # Entity classes (JPA)
│   │   │       │   └── Employee.java
│   │   │       ├── repository/            # Repository interfaces (DAO)
│   │   │       │   └── EmployeeRepository.java
│   │   │       ├── service/               # Business logic / services
│   │   │       │   └── EmployeeService.java
│   │   │       └── exception/             # Custom exceptions and handlers
│   │   │           ├── EmployeeNotFoundException.java
│   │   │           └── EmailAlreadyExistsException.java
│   │   └── resources/
│   │       ├── application.properties     # App config file
│   │       └── static/                    # Optional: For static files
│   │       └── templates/                 # Optional: For Thymeleaf (if used)
└── pom.xml                                # Maven dependencies
