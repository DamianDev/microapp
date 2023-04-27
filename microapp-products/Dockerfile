FROM eclipse-temurin:17-alpine
WORKDIR /opt/app
COPY target/microapp-products-1.0.0.jar microapp-products.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "microapp-products.jar"]