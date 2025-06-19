# HireFlow  
Interview & Job-Application Tracking API

> Organise your job hunt. Track interviews. Land faster.


## Overview
*HireFlow* is a backend-only, developer-friendly REST API that lets job seekers record every stage of their hiring journey:
* Add *job applications* with company, role, salary & source  
* Attach unlimited *interview rounds* to each application  
* Update *statuses* (APPLIED, INTERVIEWING, OFFERED, REJECTED)  
* See a *dashboard* of totals, offer-rate & average time-to-offer  
* Secure everything behind *JWT authentication*

Built with  :- *Spring Boot 3*, *MySQL*, and *Spring Security*, HireFlow follows a clean three-layer architecture (controller → service → repository) and is ready for deployment on any JVM-capable host.



## Features

 Authentication-->Register / login with BCrypt password hashing and JWT bearer tokens                 

 Job Apps-->CRUD operations for job applications, tags, referrals, and status                   

 Interview Rounds-->Multiple rounds per job: type, result, feedback, and date tracking                  

 Dashboard-->JSON analytics: total applied, offers, rejections, offer rate, average time-to-offer

 Filtering-->Query jobs by status, company name, or application month                            

 Error Handling-->Global handler returns clean JSON errors with timestamp and details                 

 Validation-->Field-level validation via annotations (e.g., non-blank, positive salary)           

 Testing-->Unit + integration tests using JUnit 5 & Spring Boot Test                           




## Tech Stack

| Layer          | Technology                     |
|----------------|---------------------------------|
| Language       | Java 21                         |
| Framework      | Spring Boot 3.3                 |
| Database       | MySQL 8                         |
| ORM            | Hibernate / Spring Data JPA     |
| Auth           | Spring Security + JWT           |
| Testing        | JUnit 5, Spring Test            |
| Build Tool     | Maven                           |
| Container      | Docker, Docker Compose (optional) |
| API Test Tool  | Postman or cURL                 |


##  Project Structure


src

 └─ main
 
     ├─ java/com/hireflow
     
     │    ├─ config          # security config, JWT filters, password encoder
     
     │    ├─ controller      # REST endpoints
     
     │    ├─ dto             # request / response payloads
     
     │    ├─ exception       # custom exceptions & handlers
     
     │    ├─ model           # JPA entities
     
     │    ├─ repository      # Spring Data interfaces
     
     │    └─ service         # business logic layer
     
     └─ resources
          ├─ application.yml # DB + JWT config
          
          └─ db/migration    # SQL migrations (if Flyway used)


## 🗄 Data Model (Simplified)

User
 └─── has many ─── JobApplication
                        └─── has many ─── InterviewRound

- User: username, email, password (hashed)
- JobApplication: company, role, salary, status, applied date
- InterviewRound: round type, date, feedback, result



## Getting Started

### 1. Clone the Repo
bash
git clone https://github.com/YOUR_USERNAME/hireflow-backend.git
cd hireflow-backend


### 2. Setup MySQL
Create a database:
sql
CREATE DATABASE hireflow;


### 3. Configure application.yml
yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hireflow
    username: root
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
jwt:
  secret: your-secret-key
  expirationMs: 3600000


### 4. Run the App
bash
./mvnw spring-boot:run


##  Sample API Requests

###  Register & Login
http
POST /api/auth/register
{
  "username": "john",
  "email": "john@example.com",
  "password": "secure123"
}

POST /api/auth/login
{
  "username": "john",
  "password": "secure123"
}


###  Create Job Application
http
POST /api/jobs
Authorization: Bearer <token>
Content-Type: application/json

{
  "company": "Acme Corp",
  "role": "Backend Developer",
  "salary": 800000,
  "status": "APPLIED",
  "source": "LinkedIn"
}


###  Add Interview Round
http
POST /api/jobs/1/rounds
Authorization: Bearer <token>
Content-Type: application/json

{
  "type": "TECHNICAL",
  "date": "2025-06-18",
  "feedback": "Strong problem-solving",
  "result": "PASSED"
}


###  View Dashboard
http
GET /api/dashboard
Authorization: Bearer <token>




##  Sample Dashboard Output
json
{
  "totalApplications": 10,
  "offersReceived": 3,
  "rejections": 4,
  "pending": 3,
  "averageTimeToOfferDays": 17
}


##  Running Tests
bash
./mvnw test


##  Possible Future Features
- Email reminders to follow up on pending jobs  
- Export job data to CSV/Excel  
- Google OAuth login  
- React frontend dashboard  
- Job offer document upload


##  License
This project is licensed under the MIT License. See the LICENSE file for more information.


## 👤 Author
*Prerana Babali* 
GitHub: [@prernababli](https://github.com/prernababli)  
LinkedIn: [https://linkedin.com/in/preranababali]

