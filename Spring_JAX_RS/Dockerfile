# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the host to the container
COPY ./out/artifacts/Spring_JAX_RS_jar/Spring_JAX_RS.jar app.jar

# Specify the command to run the jar file
CMD ["java", "-jar", "app.jar"]