# Use a base image with JDK 11 and Maven installed
FROM maven:3.8.1-openjdk-11-slim AS build

# Set the working directory
WORKDIR /app

# Copy the POM file first for efficient dependency fetching
COPY pom.xml .

# Fetch dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application
COPY src ./src

# Build the application
RUN mvn clean package

# Package the application into a JAR file
FROM adoptopenjdk:11-jre-hotspot AS production

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/backend.jar ./app.jar

# Expose the port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
