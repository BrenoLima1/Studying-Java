# CRUD People

This project is a demonstration of a simple CRUD (Create, Read, Update, Delete) application using Spring Boot.

## Technologies Used

- Spring Boot
- Java 21
- Spring Data JPA
- H2 Database
- Spring Web

## Features

- Create a new person
- Read all people
- Update a person
- Delete a person

## How to Run

1. Clone the repository
2. Run the application using the command `mvn spring-boot:run`
3. The application will be accessible at `http://localhost:8080`

## Endpoints

- **POST** `/api/persons` - Create a new person
- **GET** `/api/persons` - Read all people
- **PUT** `/api/persons/update/{id}` - Update a person
- **DELETE** `/api/persons/{id}` - Delete a person

## Example Request Body
