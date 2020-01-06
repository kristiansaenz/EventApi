# EventApi

# Setup

1. Install Java 8 and maven

2. Run "java -version" and "mvn -v". Should have java 1.8 and maven installed to run.

2. Clone repository

# Run

3. Go into cloned project directory and in terminal run "mvn clean test spring-boot:run"


# Test

Use curl, postman, insomnia .. etc to test endpoints!

Endpoints: 

  - To create event: http://localhost:8080/events/create
    Request body example: 
    {
	  "name": "Trekking Day",
		"date": "25/01/2020 07:30:00",
		"address": "0362 Rivendell Rd"
    }
    You don't need to send id. The api will generate a uuid for the event you create.
    
  - To find event by id: http://localhost:8080/events/{id}
    Send event id by path parameter.
    Here's one that exists -> http://localhost:8080/events/93596f2d-b5e3-4c39-94eb-be7d7fe7efb4
    
  - To get all events: http://localhost:8080/events/
    
