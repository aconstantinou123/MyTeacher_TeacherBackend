FROM openjdk:8-alpine
ENV PROJECT_HOME /opt/app
RUN apk update && apk add bash
ADD ./target/Teacher-0.0.1-SNAPSHOT.jar $PROJECT_HOME/Teacher-0.0.1-SNAPSHOT.jar
COPY ./wait-for-it.sh $PROJECT_HOME/wait-for-it.sh
WORKDIR $PROJECT_HOME
EXPOSE 3001
RUN chmod +x ./wait-for-it.sh
CMD ["./wait-for-it.sh", "mongo:27017", "--", "java", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/teacher", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./Teacher-0.0.1-SNAPSHOT.jar"]