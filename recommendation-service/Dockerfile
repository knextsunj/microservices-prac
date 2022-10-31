FROM eclipse-temurin:17

EXPOSE 8080

ADD ./target/recommendation-service-0.0.1-SNAPSHOT.jar recommendation.jar

ENTRYPOINT ["java","-jar","/recommendation.jar"]