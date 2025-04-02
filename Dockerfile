#FROM azul/zulu-openjdk:17-latest
FROM openjdk:17-jdk-slim
LABEL authors="vusimuzi.masilela"
MAINTAINER VUSIEOZIL

# Copy our actual project files into the container.
COPY target/taco-cloud-application-0.0.1-SNAPSHOT.jar taco-application.jar

EXPOSE 8443

# When the container starts, run the Spring Boot app using Maven.
ENTRYPOINT ["java","-Dspring.profiles.active=container,jms", "-jar", "taco-application.jar"]