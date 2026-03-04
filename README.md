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

# Admin Dashboard & Account Creation Module

# Admin Dashboard Features
  - Session-based admin access control
  - Navigation interface for account management
  - Modular structure for future extensions (View Users, Delete Account, Transactions)
  - The dashboard is protected using session validation to prevent unauthorized access.

# Account Creation Module
The Account Creation feature allows the admin to:
  - Enter user details (Name, Email)
  - Set initial deposit amount
  - Select account type (Savings / Current)
  - Validate input data before processing

# Account Number Generation
The account number is generated automatically using the database AUTO_INCREMENT primary key (ID).
Each new account receives a unique account number based on the incremented ID value.

# View Accounts Module
The View Accounts module allows the admin to retrieve and display all registered user accounts in a structured tabular format.

# This feature follows the MVC architecture:
  - Controller: ViewAccountsServlet handles the request.
  - Service Layer: Processes business logic.
  - DAO Layer: Fetches account data using JDBC.
  - View (JSP): Displays the data in a styled table.

# Features
  - Fetches all account records from the database
  - Displays account number (AUTO_INCREMENT ID), name, email, balance, and accountNumber
  - Styled table with alternating row colors for better readability
  - Session-based access protection to restrict unauthorized users
  - This module demonstrates proper separation of concerns, clean data flow from database to UI, and secure admin-level data visibility.

# Admin Profile Module
The Admin Profile module allows authenticated administrators to view their profile information securely within the system.

This feature is implemented using proper MVC architecture:
  - Controller: AdminProfileServlet
  - View: adminProfile.jsp
  - Session Management: Used to maintain authentication state

# Key Features
  - Session-based access control
  - Redirects to login page if session is not active
  - Displays admin ID, name, and email
  - Password is not exposed in the UI

# Admin Logout Module
The Logout Module ensures secure termination of an authenticated admin session. Once the admin clicks the logout option from the dashboard, the system invalidates the current session and redirects the user to the login page.

# Key Features
  - Uses HttpSession.invalidate() to destroy the active session.
  - Prevents unauthorized access to protected pages after logout.
  - Implements cache control headers to prevent browser back-button access to restricted pages.
  - Redirects the admin safely to the login page after logout.

# Flow
```
Admin Dashboard
        ↓
Logout Button
        ↓
LogoutServlet
        ↓
Session Invalidated
        ↓
Redirect to Admin Login Page
```

# Delete Account Module
The Delete Account Module allows the administrator to remove user accounts from the banking system. The admin provides a valid account number, and the system verifies it before deleting the account from the database.

# Key Features
  - Admin can delete user accounts using the account number.
  - Input validation ensures the account number is not empty or invalid or less than 10 characters.
  - Uses the MVC architecture (JSP -> Servlet → Service → DAO).
  - Displays success or error messages based on the deletion result.

# Flow
```
DeleteAccount.jsp
        ↓
AdminDeleteAccountServlet
        ↓
AdminService
        ↓
AdminDAO
        ↓
Database
```

# Validation
The system checks:
  - Account number is provided.
  - Account exists in the database before deletion.
