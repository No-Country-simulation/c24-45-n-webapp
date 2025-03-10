# Usar una imagen de Maven para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usar una imagen de Java
FROM openjdk:21-slim

# Crear un directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado por Maven
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]