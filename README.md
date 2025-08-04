<br />
<div align="center">
<h3 align="center">PRAGMA PLAZOLETA - MESSAGE SERVICE</h3>
  <p align="center">
    Microservice for sending SMS notifications using Twilio API with hexagonal architecture.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
* ![Twilio](https://img.shields.io/badge/Twilio-F22F46?style=for-the-badge&logo=twilio&logoColor=white)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)
* Twilio Account [https://www.twilio.com/try-twilio](https://www.twilio.com/try-twilio)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clone the repo
2. Change directory
   ```sh
   cd ms-message
   ```
3. Create a new database in MySQL called powerup
4. Update the database connection settings 
   ```yml
   # src/main/resources/application.yml   
   spring:
      datasource:
          url: jdbc:mysql://localhost/powerup
          username: root
          password: 1234
   ```
5. Configure Twilio credentials (see [TWILIO_SETUP.md](TWILIO_SETUP.md))

<!-- USAGE -->
## Usage

1. Right-click the class PowerUpApplication and choose Run
2. Open [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html) in your web browser

### API Endpoints

#### Send Notification
```bash
POST /api/v1/notification/send
Content-Type: application/json

{
  "pin": "1234",
  "message": "Hello from your app!",
  "phoneNumber": "+1234567890"
}
```

<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage

## Architecture

This project follows Hexagonal Architecture (Clean Architecture) principles:

- **Domain Layer**: Business logic and entities
- **Application Layer**: Use cases, DTOs, and handlers
- **Infrastructure Layer**: External services (Twilio) and REST controllers


