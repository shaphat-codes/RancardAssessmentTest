# Use a base image with Java installed
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/your-application.jar app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
