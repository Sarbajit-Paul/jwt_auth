# Spring Boot JWT Authentication Project
This project demonstrates how to implement JSON Web Token (JWT) authentication in a Spring Boot application to connect to a MySql database and further perform different DML commands on the Database.

The project also uses Maven dependency and is compiled into a JAR file.

And can be tested at

Login Authentication and Token generation: http://localhost:8080/api/auth/login

Fetching Data: http://localhost:8080/api/payportal

Data Entry: http://localhost:8080/api/payportal/dataEntry

Data Deletion: http://localhost:8080/api/payportal/dataDelete

Furthermore the Token are implemented using ExpiringSet such that they would expire after 20 min.
