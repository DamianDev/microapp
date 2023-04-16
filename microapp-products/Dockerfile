FROM eclipse-temurin:17
WORKDIR /opt/app
ARG JAR_FILE=target/microapp-products-1.0.0.jar
COPY ${JAR_FILE} microapp-products.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar","microapp-products.jar"]