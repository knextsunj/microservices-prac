FROM eclipse-temurin:17

EXPOSE 8080

ADD ./target/review-service-0.0.1-SNAPSHOT.jar review.jar

ENTRYPOINT ["java","-jar","/review.jar"]