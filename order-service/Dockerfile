FROM openjdk:17-ea-11-jdk-slim

VOLUME /

COPY /build/libs/order-service.jar order-service.jar

ENTRYPOINT ["java", "-jar", "order-service.jar"]