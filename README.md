# Spring Boot with Kafka Producer Example

This Project covers how to use Spring Boot with Rest and Jpa Spring 

## Call 
## Retrieve all students
- curl --location 'http://localhost:8081/avanade/students'

# Create new student

curl --location 'localhost:8081/avanade/newstudent' --header 'Content-Type: application/json' --data '{
"name":"Pietro",
"passportNumber": "33333",
"courses": [{
"id":"2",
"name":"c"
}]
}'


## Link to view H2 Console
- http://localhost:8081/h2-console/



