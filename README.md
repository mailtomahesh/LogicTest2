# LogicTest2
The base URL is http://localhost:8082/ 
Note: The port number is to be configured in the file application.properties available under the folder src/main/resources.

RESTful webservices are being used to implement the functionalities. HTTP GET request is being used to implement the functionalities.

The URL of Random Number Generation Service is the following: http://localhost:8082/

Note 1: JSON string is output in the browser. Note 2: The number of random numbers that are randomly generated is also generated randomly.This means that any number of numbers from 2 to 10 would get generated for addition. Note 3: The range of the numbers generated would be from 1 to 101.

A sample URL to access the Addition Result Check Service is the following: http://localhost:8082/AdditionResult/97,64,41/202

This is actually in the format like the following: http://localhost:8080/AdditionResult/{comma-separated-numbers}/{total}

JUnit tests are available for the following 3 conditions:
The number of random numbers generated is greater than 1. 
Provided total matches the total of the numbers.
Provided total does not match the total of the numbers.

Note: Spring Boot is being used for the development of the functionalities.

Note: Eclipse IDE was used for development.

Note: It was not feasible to implement HTTP 400 error for incorrect addition total in the request.. Hence, a corresponding return message has been provided accordingly.
