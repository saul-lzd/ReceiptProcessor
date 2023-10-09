FROM openjdk:17

WORKDIR /app

COPY ./target/receipt-processor.jar /app

EXPOSE 8080

CMD ["java", "-jar", "receipt-processor.jar"]