# Animal Shelter

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Running the application locally](#running-the-application-locally)
* [Screenshots](#screenshots)

## General info

This is a web application requiring authentication. Authenticated users can read the content and also manipulate the data of animals staying in the shelter. The data is stored in the MySQL database.

So far, the concept assumes that the application is used by shelter employees who can modify animal descriptions, add photos, delete data, etc. When an employee adds a new resident to the shelter, the application automatically sends a message to the specified (hard coded) email address.

To search for records, user can aslo use full-text search. Its goal is to find results that are approximate in meaning and quickly issue them. Thus, the result will be much more useful to the user, as it will be more relevant. Down below, you can check out the screenshot from searching for the 'dog' phrase.

The application will be expanded with further functions, such as browsing by users who are not logged in (potential willing to adopt an animal), adoption forms, e-mail contact via the website.


## Technologies
Project is created with:
* Java version: 17
* Spring Boot version: 2.7.1 (with Spring Security, Spring Email, Spring Data JPA)
* Bootstrap version: 5
* Thymeleaf version: 3.0
* MySQL version: 8.0

## Setup

The project includes the Maven wrapper, so there is no need to install Maven to run the app. However, you need MySQL Server. 

To use Spring Boot with Spring Data JPA and Hibernate, configure database connection information in the application.properties as follows (remember to modify URL, username and password matching your MySQL database):

```
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://localhost:3306/your_database?createDatabaseIfNotExist=true
spring.datasource.username = root
spring.datasource.password = password
```

Set up application.properties file with configurations required for using Gmail SMTP server. Your Gmail address can be provided as the username. To generate password, you need to enable 2-step verification for your account.

```
spring.mail.host = smtp.gmail.com
spring.mail.port = 587
spring.mail.username = youremail2@gmail.com
spring.mail.password = yourgeneratedpassword
```

Note, that if you run application for the first time, new created database is empty. Run app in the browser and register as a new user. 

Email is sent when you add new animal to database. Remember, that application needs the internet access to do that. ;)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.poecat.animalshelter.AnimalShelterApplication class from your IDE.

Alternatively, you can use the Spring Boot Maven plugin in root directory:

```
mvn spring-boot:run
```

## Screenshots

![Zrzut ekranu (61)](https://user-images.githubusercontent.com/84228264/177832216-5570479e-71a4-445c-a4b9-ac5b7a0cee3d.png)

![Zrzut ekranu (59)](https://user-images.githubusercontent.com/84228264/177832226-2745661f-fff7-4072-ba5f-683621f471f8.png)

![Zrzut ekranu (62)](https://user-images.githubusercontent.com/84228264/177836413-90f48e62-6eb1-4d0b-8e68-766644acb32b.png)


