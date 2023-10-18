# Employee Management System Backend

This is the backend repository for the Employee Management System, a comprehensive full-stack web application designed for managing employee data. The backend is built with Spring Boot and interacts with a MySQL database.

- [Overview](#overview)
- [Features](#features)
- [Database Configuration](#database-configuration)
- [CORS Configuration](#cors-configuration)
- [Entity Definition](#entity-definition)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [Frontend Repository](#frontend-repository)

## Overview

The Employee Management System Backend provides the server-side logic and APIs required for the frontend to interact with the database and perform CRUD operations on employee data. It serves as the core component of the full Employee Management System.

- **Backend Framework**: [Spring Boot](https://spring.io/projects/spring-boot)
- **Database**: MySQL

## Features

The backend of the Employee Management System includes a set of key features:

1. **RESTful API Endpoints**: Exposes RESTful APIs for Create, Read, Update, and Delete (CRUD) operations on employee data.

2. **Cross-Origin Resource Sharing (CORS)**: Supports Cross-Origin Resource Sharing, allowing the frontend to communicate with the backend.

3. **Entity Management**: Utilizes Java Persistence API (JPA) for entity management, mapping Java objects to database tables.

4. **Database Configuration**: Configures database connection details to connect to a MySQL database.

## Database Configuration

The backend requires the following database configuration specified in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/empmgn
spring.datasource.username={sql_username}
spring.datasource.password={sql_password}
server.port=8080
```

Ensure that your MySQL database is up and running, and the provided database details are accurate for successful interaction with the database.

## CORS Configuration

Cross-Origin Resource Sharing (CORS) is configured to allow requests from the frontend application running at `http://localhost:3000`. The `@CrossOrigin` annotation is used for this purpose in the controller.

```java
@CrossOrigin(origins = "http://localhost:3000")
```

Feel free to adjust the `origins` attribute as needed based on your frontend's URL.

## Entity Definition

The `EmployeeEntity` class defines the structure of the employee data that is stored and managed in the system. It uses JPA annotations to map Java objects to a database table.

```java
@Entity
@Data
@Table(name = "employee_table")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int empId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String department;
    private BigDecimal salary;
    private location;
}
```

This entity class represents the employee data model, and it is used for database operations.

## API Endpoints

The Employee Management System Backend provides a set of RESTful API endpoints for managing employee data. The available endpoints include:

- `GET /employees`: Retrieve a list of all employees.
- `GET /employees/{id}`: Retrieve an employee by ID.
- `POST /employees`: Create a new employee.
- `PUT /employees/{id}`: Update an employee by ID.
- `DELETE /employees/{id}`: Delete an employee by ID.

You can interact with these endpoints to perform CRUD operations on employee data.

## Getting Started

To set up and run the Employee Management System Backend on your local machine, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/RohanWork/employee-management-system-core-backend-1.git
   ```

2. Change to the project directory:

   ```bash
   cd employee-management-system-core-backend-1
   ```

3. Ensure that you have a MySQL database set up and configure the database details in the `application.properties` file as shown in the [Database Configuration](#database-configuration) section above.

4. Build and run the Spring Boot application:

   ```bash
   ./mvnw spring-boot:run
   ```

   or

   ```bash
   mvn spring-boot:run
   ```

5. The backend will be accessible at `http://localhost:8080`.

## Contributing

Contributions to this project are welcome! If you'd like to contribute to the development and improvement of the Employee Management System Backend, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix: `git checkout -b feature-name`.

3. Make your changes and commit them: `git commit -m 'Add feature'`.

4. Push your changes to the forked repository: `git push origin feature-name`.

5. Open a pull request to the original repository.

## Frontend Repository

To interact with the frontend of the Employee Management System, visit the [Frontend Repository](https://github.com/RohanWork/employee-management-system-core-frontend-2). The frontend repository provides the user interface for the system.

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#using.devtools)

## Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
