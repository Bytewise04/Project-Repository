# Use OpenJDK 17 as base image
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/project.manager-1.0.jar demo.jar
# Expose port
EXPOSE 8080
# Run the JAR
ENTRYPOINT ["java", "-jar", "demo.jar"]

