# Spring Boot Security with JWT Authentication

## Overview
This project is a **Spring Boot application** with **Spring Security** implemented at the method level. It uses **JWT (JSON Web Token)** for secure authentication and authorization.

## Features
- **Spring Boot** for backend API development.
- **Spring Security** for securing endpoints.
- **JWT Authentication** for stateless security.
- **Role-Based Access Control (RBAC)** to restrict API access.
- **Spring Security Annotations** (`@PreAuthorize`, `@Secured`, etc.) for method-level security.
- **Swagger API Documentation** for easy testing.

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Web
- Spring Data JPA
- JWT (JSON Web Token)
- Hibernate
- PostgreSQL / MySQL (Database)
- Maven

## Installation & Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-repo/spring-security-jwt.git
   cd spring-security-jwt
   ```

2. **Configure the Database:**
   Update `application.properties` or `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```

## Security Implementation

### **JWT Authentication Flow:**
1. User logs in with username & password.
2. If authenticated, a **JWT token** is generated.
3. Token is included in the **Authorization Header** (`Bearer Token`).
4. Every request to protected endpoints is validated with this token.

### **Method-Level Security Annotations:**
- `@PreAuthorize("hasRole('ADMIN')")` – Restricts access to users with the `ADMIN` role.
- `@Secured("ROLE_USER")` – Ensures only `USER` role can access the method.
- `@RolesAllowed({"USER", "ADMIN"})` – Allows multiple roles.

Example:
```java
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin")
public String adminAccess() {
    return "Admin Content";
}
```

## API Endpoints

| Method | Endpoint          | Description              | Access |
|--------|------------------|--------------------------|--------|
| POST   | `/auth/register` | Register a new user      | Public |
| POST   | `/auth/login`    | Authenticate and get JWT | Public |
| GET    | `/users/me`      | Get current user details | Authenticated |
| GET    | `/admin`         | Admin-only content      | ADMIN |

## Testing with Postman
1. **Register User:** `POST /auth/register`
2. **Login:** `POST /auth/login` → Get JWT Token
3. **Access Protected APIs:** Use `Bearer <JWT_TOKEN>` in Authorization Header.

## Swagger API Documentation
Swagger is available at:
```
http://localhost:8080/swagger-ui/index.html
```

## Contribution
Feel free to fork this repository and contribute with pull requests.

## License
This project is licensed under the MIT License.

