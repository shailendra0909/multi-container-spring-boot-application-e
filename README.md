# multi-container-spring-boot-application
This project aims to create a multi container application based on spring-boot and mongodb.

Main focus of this small project to create a student record management api in spring-boot which connect to the mango database. We will create docker image for our application and then run our application with docker-compose CLI to create multi-container application. 
I am creating this application as a working example for myself. I may help you to understand how container works and to orchestrate two container. On the similer line, we can connect muti-container application talking to each other.

So let's start step by step. I will be taking abot small small thing which may help in understanding the flow of the code. 
Tools which I have used in this example are (small knowledge is required about these tools):
1. Docker //for creating our docker image, docker-compose can also be used.
2. docker-compose //for running multi-container application
3. maven //for build and dependency management.
4 spring-boot //a framework provided by spring to quickly create application with minimal configuration.
5. mongo db //nosql database. we will use it to store our students record.
6 and JDK ....ofcourse. 

I am using Spring Tool Suite as development IDE. but any IDE can be used as long as it support application developement in the java.

Our api will be available under application context as "/student"

create a spring boot application and put required dependencies in the pom.xml in project root directory.(please refer the project pom.xml)

create a StudentResource class and add required annotation. These annotation provide hint to the spring runtime to create beans and  and inject required dependencies. Most important part of the this application is it's configuration. (please refer the application.properties file. it's self explainotry.)

Now create a jar of our application by running "mvn clean install -DskipTests" in project root directory. copy the jar in a empy directory(let say myapp dir). create a Dockerfile in the same directory(please refer Dockerfile) in the project. Now run command "docker build -t spsingh-java-app1 ." It will create a new image of our application with name “spsingh-java-app1”. You can check this by running “docker images” on command prompt.

As next step, download the mongo db image from the docker-hub by running the command "docker pull mongo". It will pull the latest image of mongodb.

Now create a docker-compose.yml file in your system in any directory(please refer the same file in project)

To explain what we have in yml file:
we have created 2 services "web" and "mongohost" and one network "spring-boot-network". since both the services will be available on the same docker-network, out spring-boot application can easly seach the mongohost as configured in the application.properties and connect to it.

You can test our application using “Postman” by entering the url “localhost:5000/student-api/students”. Since at first there is no record available, we will get empty array. 
Lets create a few record by posting using followin json data:

 {
        "fname": "prateek gautam",
        "lname": "singh",
        "age": 27
    }

Now you can again use get request and see the saved record. Similery try with modifying and deleting the record with PUT and DELETE option in Postman with respective api.

