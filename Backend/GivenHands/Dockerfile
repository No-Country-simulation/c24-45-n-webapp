FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
WORKDIR /app
COPY --from=builder /app/target/GivenHands-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]