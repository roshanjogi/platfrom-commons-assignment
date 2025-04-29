# Employee & Department Management API

This Spring Boot application provides REST APIs for managing employees and departments, with separate controllers for **Admin** and **Employee** roles.

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## API Endpoints

### Admin APIs (`/api/admin`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/welcome` | Welcome message for admin |
| `POST` | `/employee` | Add a new employee |
| `POST` | `/department` | Add a new department |
| `PUT`  | `/{employeeCode}/assign-departments` | Assign departments to an employee |
| `GET`  | `/search-by-name?name={name}` | Search employees by name |
| `GET`  | `/search-by-department-name/{departmentName}` | Get employees by department name |

### Employee APIs (`/api/employee`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/login?employeeCode={code}&dateOfBirth=yyyy-MM-dd` | Authenticate employee login |
| `PUT`  | `/{employeeCode}/profile` | Update employee profile (email, mobile, emergency contact) |
| `GET`  | `/{employeeCode}/departments` | Get departments assigned to an employee |

---

## Notes

- Data is exchanged using JSON.
- DTOs and Mappers are used to separate internal entities from exposed API objects.
- Custom exceptions handle scenarios like invalid login, duplicate employee, and missing records.
- Swagger documentation for auto-generated API documentation.

---

## Getting Started

1. Clone the repo
2. Configure `application.properties` for DB access
3. Run the app: `mvn spring-boot:run`

---

## Author - Roshan
"# platfrom-commons-assignment" 
