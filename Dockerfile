FROM openjdk:8
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java", "-jar","student-api-0.0.1-SNAPSHOT.jar"]
