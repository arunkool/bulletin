FROM openjdk:8
ADD target/bulletin-0.0.1-SNAPSHOT.jar bulletin-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bulletin-0.0.1-SNAPSHOT.jar"]