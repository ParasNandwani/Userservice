FROM openjdk:17-jdk-slim


WORKDIR /app

COPY pom.xml .
RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package

EXPOSE 8080

CMD ["java", "-jar", "target/userservice.jar"]