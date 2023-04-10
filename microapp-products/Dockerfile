FROM eclipse-temurin:17
WORKDIR /opt/app
ARG JAR_FILE=build/libs/microapp-products-1.0.0.jar
COPY ${JAR_FILE} microapp-customer.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","microapp-customer.jar"]