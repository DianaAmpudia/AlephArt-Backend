# Stage 1: Build Stage
FROM eclipse-temurin:21-jdk AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY alephart/gradlew gradlew
COPY alephart/gradle gradle
COPY alephart/build.gradle .
COPY alephart/settings.gradle .

# Copy the source code
COPY alephart/src src

# Grant execution rights to the Gradle wrapper
RUN chmod +x gradlew

# Build the application
RUN ./gradlew clean build -x test

# Stage 2: Runtime Stage
FROM eclipse-temurin:21-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=prod

# Expose the port that your application runs on
EXPOSE 8080

# Entry point to run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]