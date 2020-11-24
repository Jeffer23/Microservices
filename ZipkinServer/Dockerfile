FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/zipkin-server.jar zipkin-server.jar
ENTRYPOINT ["java", "-jar", "/zipkin-server.jar"]