# EventApi

# Setup

1. Install Java 8 and maven

2. Run "java -version" and "mvn -v". Should have java 1.8 and maven installed to run.

2. Clone repository

# Run

Go into cloned project directory and in terminal run "mvn clean test spring-boot:run"

OR

You can install my docker image and run in terminal with command "docker run -p 5000:8080 ksaenz7/spring-boot-events-api-demo:0.0.1-SNAPSHOT"

# Test

Use curl, postman, insomnia .. etc to test endpoints!

* NOTE: If running docker image, use http://localhost:5000 *

Endpoints: 

  - To create event: http://localhost:8080/events/create <br/>
  
    Request body example:\
    {\
	  "name": "Trekking Day",\
		"date": "25/01/2020 07:30:00",\
		"address": "0362 Rivendell Rd"\
    }
    
    You don't need to send id. The api will generate a uuid for the event you create.
    <br/>
  - To find event by id: http://localhost:8080/events/{id} <br/>
    Send event id by path parameter. <br/>
    Here's one that exists -> http://localhost:8080/events/93596f2d-b5e3-4c39-94eb-be7d7fe7efb4
    
  - To get all events: http://localhost:8080/events/
    
