FROM eclipse-temurin:17

LABEL mentainer="manoyasamistra@gmail.com"

WORKDIR /app


COPY target/cv-form-0.0.1-SNAPSHOT.jar /app/cv-form.jar

ENTRYPOINT ["java", "-jar", "cv-form.jar"]