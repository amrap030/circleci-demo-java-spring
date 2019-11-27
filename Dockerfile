FROM openjdk:12-jdk-alpine

ENV VERSION=1.1
ENV SERVER_PORT=9000
ENV SPRING_DATASOURCE_USERNAME=dbuser
ENV SPRING_DATASOURCE_PASSWORD=pass
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/quotes

ADD target/demo-java-spring-1.0-SNAPSHOT.jar server.jar

EXPOSE $SERVER_PORT

ENTRYPOINT java -jar server.jar
