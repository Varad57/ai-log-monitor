# Step 1: Use a lightweight JDK 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file (Make sure you ran 'mvn clean package' first!)
COPY target/*.jar app.jar

# Step 4: Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]