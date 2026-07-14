# 🏥 Digital Healthcare System

A secure backend REST API project developed using **Java, Spring Boot, Spring Security (JWT), Hibernate/JPA, and MySQL**. The system provides role-based authentication and healthcare management functionalities for **Admin, Doctor, and Patient**.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- User Registration (Admin, Doctor, Patient)
- User Login with JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization
- Duplicate Email Validation

### 👨‍⚕️ Doctor Module
- Add Doctor
- Get All Doctors
- Get Doctor By ID
- Update Doctor
- Delete Doctor

### 🧑‍🤝‍🧑 Patient Module
- Add Patient
- Get All Patients
- Get Patient By ID
- Update Patient
- Delete Patient

### 📅 Appointment Module
- Book Appointment
- Get All Appointments
- Get Appointment By ID
- Update Appointment
- Delete Appointment
- Prevent Duplicate Appointment Booking

### 💊 Prescription Module
- Add Prescription
- Get All Prescriptions
- Get Prescription By ID
- Update Prescription
- Delete Prescription

### ✅ Validation
- Name Required
- Email Required
- Valid Email Format
- Password Required
- Minimum Password Length
- Role Required

### ⚠️ Exception Handling
- Global Exception Handler
- Custom Exceptions
- Validation Error Handling

---

# 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT Authentication
- Hibernate / JPA
- MySQL
- Maven
- Postman
- Git & GitHub

---

# 🗄️ Database

Database Name:

```text
healthcare_dbb
```

Main Tables:

- users
- doctor
- patient
- appointment
- prescription

---

# 🔑 Authentication

This project uses **JWT (JSON Web Token)** for secure authentication.

Steps:

1. Register User
2. Login User
3. Receive JWT Token
4. Send Token in Authorization Header

```text
Authorization: Bearer <JWT_TOKEN>
```

---

# 📌 API Endpoints

## Authentication

| Method | Endpoint |
|--------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

---

## Doctor

| Method | Endpoint |
|--------|----------|
| POST | /doctors |
| GET | /doctors |
| GET | /doctors/{id} |
| PUT | /doctors/{id} |
| DELETE | /doctors/{id} |

---

## Patient

| Method | Endpoint |
|--------|----------|
| POST | /patients |
| GET | /patients |
| GET | /patients/{id} |
| PUT | /patients/{id} |
| DELETE | /patients/{id} |

---

## Appointment

| Method | Endpoint |
|--------|----------|
| POST | /appointments |
| GET | /appointments |
| GET | /appointments/{id} |
| PUT | /appointments/{id} |
| DELETE | /appointments/{id} |

---

## Prescription

| Method | Endpoint |
|--------|----------|
| POST | /prescriptions |
| GET | /prescriptions |
| GET | /prescriptions/{id} |
| PUT | /prescriptions/{id} |
| DELETE | /prescriptions/{id} |

---

# 📬 API Testing

All APIs were tested using **Postman**.

---

# ▶️ How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/shivaniishinde/digital-healthcare-system.git
```

## 2. Open the project

Open the project in Eclipse IDE or IntelliJ IDEA.

## 3. Configure Database

Update your MySQL username and password in:

```text
src/main/resources/application.properties
```

## 4. Create Database

```sql
CREATE DATABASE healthcare_dbb;
```

## 5. Run the Application

Run the Spring Boot application.

## 6. Test APIs

Use the included Postman Collection to test all APIs.

# 📂 Project Structure

```text
src
 ├── auth
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── repository
 ├── security
 ├── service
 └── resources
```

---

# 👩‍💻 Developed By

**Shivani Dnyaneshwar Shinde**

- Java Backend Developer
- Spring Boot Developer
- Open to Work

GitHub:
https://github.com/shivaniishinde

LinkedIn:
https://www.linkedin.com/in/shivanii-shinde-96k

---

## ⭐ Project Highlights

- RESTful API Development
- JWT Authentication
- Spring Security
- Role-Based Access Control
- CRUD Operations
- Hibernate/JPA
- MySQL Integration
- Bean Validation
- Global Exception Handling
- Postman API Testing
- Git & GitHub
