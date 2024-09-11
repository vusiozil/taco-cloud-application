FROM azul/zulu-openjdk:17-latest
LABEL authors="vusimuzi.masilela"
MAINTAINER VUSIEOZIL

# Copy our actual project files (code, resources, etc.) into the container.
COPY target/taco-cloud-0.0.1-SNAPSHOT.jar taco-application.jar

# When the container starts, run the Spring Boot app using Maven.
ENTRYPOINT ["java", "-jar", "/taco-application.jar"]
