
FROM openjdk:11 

COPY gradlew .
COPY gralde gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:11

ARG JAR_FILE=build/libs/*.jar

RUN mkdir -p /app/

ADD ${JAR_FILE} /app/discovery-server.jar

EXPOSE 8881

# execute the application
ENTRYPOINT ["java","-jar", "/app/discovery-server.jar"]
