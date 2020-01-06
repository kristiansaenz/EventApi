# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="kristian.saenz49@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 seen to world outside container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/events-0.0.1-SNAPSHOT.jar

# Add the application's jar to container
ADD ${JAR_FILE} events-api.jar

# Run jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/events-api.jar"]