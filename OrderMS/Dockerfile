FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/orderms.jar orderms.jar
ENTRYPOINT ["java", "-jar", "/orderms.jar"]