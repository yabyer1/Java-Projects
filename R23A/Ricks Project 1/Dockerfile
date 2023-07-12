# Use a base image with Java installed
FROM openjdk:latest

# Set the working directory
WORKDIR /app

# Copy all Java files to the container
COPY . /app

# Compile the Java code
RUN javac *.java

# Set the entry point for the Docker image
CMD ["java", "Main"]
