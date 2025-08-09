# Student Record Management - Backend (Spring Boot)

**Backend REST API** for a Student Record Management system.

## Features
- JWT authentication (`POST /api/auth/login`)
- CRUD for students (`/api/students`): create, list, update, delete
- Business logic:
  - Percentage = average of 5 marks
  - Division:
    - >= 60% → First Division
    - >= 50% and < 60% → Second Division
    - < 50% → Fail
- Validation:
  - `name`: required, min 3 chars
  - `age`: required, between 5 and 25
  - `marks`: exactly 5 integers, each 0–100
- H2 (default) with sample data. Optionally MySQL/Postgres via `application.properties` or docker-compose.
- DTOs used for request/response
- Unit tests for service layer (optional)

## Tech stack
- Java 17+ (recommended)
- Spring Boot 3.x
- Spring Web, Spring Data JPA, Spring Security
- JJWT (or io.jsonwebtoken) for JWT
- H2 (dev), MySQL/Postgres (optional)
- Maven (or Gradle)
- JUnit 5 for tests
- Lombok (optional)

---

## Quick start (local)

Prereqs: JDK 17+, Maven, Git

```bash
# clone
git clone https://github.com/<your-username>/student-records-backend.git
cd student-records-backend

# build and run
mvn clean package
mvn spring-boot:run

# or run jar
java -jar target/student-records-backend-0.0.1-SNAPSHOT.jar
