# Banking Web Application (MVC Architecture)

# Overview

  - This project is a web-based banking application developed using Java Servlets (Jakarta EE), JSP, JDBC, and Apache Tomcat, following the MVC (Model–View–Controller) architecture.
  - Currently, the system implements the Admin Authentication Module, which includes secure admin registration and login functionality with proper layered separation.

# Architecture Design

The application follows a structured layered architecture:

1. Controller Layer (Servlet)
    Handles HTTP requests and responses for admin login and registration.

2. Service Layer (Business Logic)
    Performs validation such as password confirmation and business rules before database interaction.

3. DAO Layer (Database Access)
    Manages database operations using JDBC and prepared statements.

4. Model Layer (Data Objects)
    Represents the Admin entity and encapsulates admin data.

5. Util Layer (DataBase Connection)

This separation ensures scalability, maintainability, and clean code organization.

# Technologies Used

  - Java
  - Jakarta Servlet API
  - JSP
  - JDBC
  - Apache Tomcat
  - MySQL

# Features Implemented

  - Admin Registration
  - Password confirmation validation
  - Admin Login
  - Credential validation against database
  - Error handling for invalid credentials
  - MVC-based structured implementation
  - JDBC-based MySQL database integration




