# Simple Bank Transfer REST API (Java)

Minimal Spring Boot REST API project for transferring money between accounts for Synec*** Tech interview assignment.

## Features
- In-memory storage
- No authentication
- Simple REST APIs

## Run

### Build
```bash
mvn clean install
```

### Start
```bash
mvn spring-boot:run
```

## APIs

### Get all accounts
GET /accounts

### Get account by ID
GET /accounts/{id}

### Transfer money
POST /transfer

Request:
```json
{
  "fromAccount": 1,
  "toAccount": 2,
  "amount": 500
}
```
