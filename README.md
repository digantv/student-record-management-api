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
- DTOs used for request/response
- Unit tests for service layer (optional)

## Tech stack
- Java 17+ (recommended)
- Spring Boot 3.x
- Spring Web, Spring Data JPA, Spring Security
- MySQL
- Maven
- JUnit 5 for tests
- Lombok (optional)

---
##Images
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/cb4d2575-2550-499d-a267-2adca2ea48ce" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/44316a26-bae9-424f-a75d-c61c6aef7b26" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/c9aa1776-8383-454d-8342-7745755c28db" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/19f57358-036c-45c6-8a79-b9edf332a8fe" />

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

# also for running docker image:
docker run -it --name=student_container student-api:latest
