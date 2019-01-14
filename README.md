# multi-container-spring-boot-application-e
This project aims to create a multi container application based on spring-boot and mongodb
We will learn to create a spring-boot api for a sample project. Main focus of this small project to create a student record management api in spring-boot which connect to the mango database. We will create docker image for our application and then run our application with docker-compose CLI to create multi-container application. I am creating this application as a working example for myself. I may help you to understand how container works and to orchestrate two container. On the similer line, we can connect muti-container application talking to each other and searving for a purpose.
So let's start step by step. I will be taking abot small small thing which may help in understanding the flow of the code. Tools which I have used in this example are-
1. Docker //for creating our docker image, docker-compose can also be used.
2. docker-compose //for running multi-container application
3. maven //for build and dependency management.
4 spring-boot //a framework provided by spring to quickly create application with minimal configuration.
5. mongo db //nosql database. we will use it to store our students record.
6 and JDK ....ofcourse. I am using Spring Tool Suite as development IDE. but any IDE can be used as long as it support application developement in the java.

Our api will be available under application context as "/student"

create a spring boot application and put required dependencies in the pom.xml in project root directory.(please refer the pom.xml)

create a StudentResource class and add required annotation. These annotation provide hint to the spring runtime to create beans and  and inject require dependencies. Most important part of the this application is it's configuration. We have following configuration the application.properties file:

#this will define context for our api
server.servlet.context-path=/student-api

# MONGODB (MongoProperties)
spring.data.mongodb.database=StudentDB
#this will be used in the docker-compose.yml file to define database service to which our spring-boot application is connecting.
spring.data.mongodb.host=mongohost
#this define the port on which mongodb will be available.
spring.data.mongodb.port=27017

Now create a jar by running "mvn clean install -DskipTests" in project root directory. copy the jar in a empy directory(let say myapp dir). create a Dockerfile in the same directory(please refer Dockerfile) in the project. Now run command "docker build -t spsingh-java-app1 ." It will create a new image of our application.

As next step, download the mongo db image from the docker-hub by running the command "docker pull mongo".

create a docker-compose.yml file in your system.(please refer the same file ) in the project dir.

To explain what we have in yml file:
we have create 2 services "web" and "mongohost" and one network "spring-boot-network". since both the services will be available on the same docker-network, out spring-boot application can easly seach the mongohost as configured in the application.properties.

