FROM openjdk:8

ADD target/lucaskienast-stock-api.jar lucaskienast-stock-api.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","lucaskienast-stock-api.jar"]