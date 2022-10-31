FROM eclipse-temurin:17

EXPOSE 8080

ADD ./target/product-composite-service-0.0.1-SNAPSHOT.jar product-composite.jar

ENTRYPOINT ["java","-jar","/product-composite.jar"]