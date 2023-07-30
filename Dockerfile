FROM openjdk:8-jdk-slim
COPY build/libs/* mongodb.jar
EXPOSE 8083
CMD $JAVA_HOME/bin/java -Dspring.profiles.active=dev -jar mongodb.jar