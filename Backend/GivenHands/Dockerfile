FROM openjdk:21-slim

WORKDIR /app

COPY target/GivenHands-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]