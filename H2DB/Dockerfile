FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/h2db.jar h2db.jar
ENTRYPOINT ["java", "-jar", "/h2db.jar"]