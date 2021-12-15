FROM openjdk:11
COPY hello-paul-0.0.1-SNAPSHOT.jar hello-todos.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/hello-todos.jar"]