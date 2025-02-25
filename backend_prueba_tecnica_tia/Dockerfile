FROM maven:3-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml ./

COPY src ./src

RUN mvn clean install -DskipTests

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=build /app/target/backend_prueba_tecnica_tia-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]