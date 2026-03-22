# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /portfolio-project
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre-alpine
WORKDIR /portfolio-project
COPY --from=builder /portfolio-project/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]