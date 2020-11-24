FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD EurekaServer/target/EurekaServer.jar EurekaServer.jar
ADD ManageCurrencyConversionFactorMS/target/ManageCurrencyConversionFactorMS.jar ManageCurrencyConversionFactorMS.jar
CMD ["java", "-jar", "/ManageCurrencyConversionFactorMS.jar"]
ENTRYPOINT ["java", "-jar", "/EurekaServer.jar"]