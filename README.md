# IQVIA-backend-Task

## _Introduction_

You have two microservices will call each other, depending on the business need.
The microservices called Author and Book microservice.


## Features

- Book management.
- Author management.
- Separate H2 database for each microservice.
- Common application to shared application resource between microservices.
- Parent application to share the dependencies between the microservices.
- Bill of material (BOM) for centralized dependence versions
- Handling exceptions.
- Generic Response for all endpoints.
- RestTemplate configuration.

## Run application ##

> To run the application, you need to follow these order steps:

- Iqvia-bom: you need to go inside this file and run the following command.
```sh
mvn clean install
```
- Iqvia-parent: you need to go inside this file and run the following command.
```sh
mvn clean install
```
- Iqvia-common: you need to go inside this file and run the following command.
```sh
mvn clean install
```
- Iqvia-Author: you need to go inside this file and run the following command.
```sh
mvn clean install
```
- Iqvia-Book: you need to go inside this file and run the following command.
```sh
mvn clean install
```

and after following these steps, you need to run the Book and Author microservice.
> The Book microservice will be available on port 8090.
> 
> The Author microservice will be available on port 8085.

## Database:
I used an H2 database in each microservice. each database will have one table:

- `tbl_author`
- `tbl_book`

to access them via browser, you can use the following credentials:

| Microservice name | data base endpoint | username | password       |
|-------------------|--------------------|----------|----------------|
| Author            | `http://localhost:8085/api/v1/h2-console`| sa       | password |
| Book              | `http://localhost:8085/api/v1/h2-console`| sa       | password |


## APIs:
- Author APIs.
  - Create new author API
  - Get all authors API (Pageable)
  - Update number of books for specific Author (Internally API called by Book microservice)
  
- Book APIs.
    - Create new book API
    - Get all books API (Pageable)

## Access end point:

| Microservice name | end point                                          | curl | response |
|-------------------|----------------------------------------------------| -----------------| -------------- |
| Author            | http://localhost:8085/api/v1/author                | `curl --location 'http://localhost:8085/api/v1/author' \--header 'Content-Type: application/json' \--data '{"name":"author 1 test","gender":"MALE"}'`| `{"success": true,"message": "success","data": "Author has been created"}`   
| Author            | http://localhost:8085/api/v1/author?page=0&size=10 | `curl --location 'http://localhost:8085/api/v1/author?page=0&size=10'` | `{"success": true,"message": "success","data": {"content": [{"id": 1,"name": "author 1 test","gender": "MALE","numberOfBook": 1}],"pageable": {"pageNumber": 0,"pageSize": 10,"sort": {"empty": true,"sorted": false,"unsorted": true},"offset": 0,"paged": true,unpaged": false},"last": true,"totalPages": 1,"totalElements": 1,"first": true,"numberOfElements": 1,"number": 0,"sort": {"empty": true,"sorted": false,"unsorted": true},"empty": false}}`
| Author            | Internally used                                    | Internally use | Internally use |
| Book              | http://localhost:8090/api/v1/book                  | `curl --location 'http://localhost:8090/api/v1/book' \--header 'Content-Type: application/json' \--data '{"name":"Book 1","category":"DRAMA","authorId":"1"}'` | `{"success": true,"message": "success","data": "Book has been created"}`
| Book              | http://localhost:8090/api/v1/book?page=0&size=10   | `curl --location 'http://localhost:8090/api/v1/book?page=0&size=10'` | `{"success":true,"message":"success","data":{"content":[{"id":5,"bookName":"Book 1","bookCategory":"DRAMA","authorId":1}],"pageable":{"pageNumber":0,"pageSize":10,"sort":{"empty":true,"sorted":false,"unsorted":true},"offset":0,"paged":true,"unpaged":false},"last":true,"totalPages":1,"totalElements":1,"size":10,"number":0,"sort":{"empty":true,"sorted":false,"unsorted":true},"first":true,"numberOfElements":1,"empty":false}}`









