FROM openjdk:17
ADD /target/spring-application.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]