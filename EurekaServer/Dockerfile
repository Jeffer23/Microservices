FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/EurekaServer.jar EurekaServer.jar
ENTRYPOINT ["java", "-jar", "/EurekaServer.jar"]