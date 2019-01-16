FROM openjdk:8-jdk-alpine

RUN mkdir /javalin

WORKDIR /javalin

COPY build/libs/javalin-example-1.0-SNAPSHOT.jar /javalin/javalin-example-1.0-SNAPSHOT.jar

CMD ["sh", "-c", "java -jar javalin-example-1.0-SNAPSHOT.jar"]