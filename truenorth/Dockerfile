FROM openjdk:8-jdk-alpine
MAINTAINER Frangel Rodriguez "frangele331@gmail.com"
VOLUME /tmp
ARG JAR_FILE=*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
