FROM openjdk:8-alpine
ENV PROJECT_HOME /opt/app
ADD ./target/Teacher-0.0.1-SNAPSHOT.jar $PROJECT_HOME/Teacher-0.0.1-SNAPSHOT.jar
WORKDIR $PROJECT_HOME
EXPOSE 3001
ENTRYPOINT ["java", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/teacher", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./Teacher-0.0.1-SNAPSHOT.jar"]