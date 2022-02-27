FROM adoptopenjdk/openjdk11
WORKDIR /app
COPY ./target/product-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]