FROM openjdk:11
VOLUME /tmp
EXPOSE 8090
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} student.main.jar
ENTRYPOINT ["java","-jar","/student.main.jar"]