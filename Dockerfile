# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build

RUN addgroup --system appgroup && adduser --system --ingroup appgroup --shell /bin/false appuser
USER appuser

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Verifica il contenuto della directory target
RUN ls -l /app/target



# Stage 2: Create lightweight runtime image
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl
WORKDIR /app
COPY --from=build /app/target/rest-jpa-0.0.1-SNAPSHOT.jar app.jar

# Set the user to run the application
CMD ["java", "-XX:MaxRAMPercentage=80.0", "-jar", "app.jar"]
