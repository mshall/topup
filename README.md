
  

# Microservices skeleton project!

  

  

This is a skeleton RESTful application relying mainly on **SpringBoot**.

  

Our application is doing the following

  

- Charging / adding credit to user specific wallet

- CRUD operations for the following:
		- Customers
		- Transactions
		- Wallets
		- Currency

  

# Technology stack used

  

  

- Spring boot

- Spring data

- Service Registry

- Cloud gateway

- Config Server

- Hystrix

- Postgres DB

- Lombok

- Maven

- Zipkin Server for distributed logging

- Swagger API documentation

- Docker

  

  

## Project layers

  

  

- ### Controller layer

  

This layer contains the RESTful endpoints, through which our configured endpoint can be consumed (**TransactionsController**)

  

  

- ### Service layer

  

This layer processed whats coming from the controller layer and then apply our business logic including calling the repository (database) layer.

  

  

- ### Repository layer

  

This is the database layer dealing with database operations

  

- TransactionsRepository

  

## How to run project

  

  

Project is using maven. so, you can download the project, run the following command to generate the jar file which will be the executable one for us to run the project but make sure you have maven installed on your machine:

  

  

### Steps

I've added a sample collection to prove gateway is working through attached postman collection in the root directory of this repo

Then,

Please note that APIs lists for  (topup microservic) can be accessed through Swagger:

Topup Microservice

```

[Topup Swagger URL](http://localhost:9002/topup/swagger-ui/index.html)

```

  

Students Microservice

```

http://localhost:9002/topup/swagger-ui/index.html

```

  
  
  

First of all, make sure to install **zipkin** server on your local machine:

This can be done through **docker** commands:

Make sure you have docker installed then:

```

docker pull openzipkin/zipkin

```

  

Then run the following command to start zipkin server:

```

docker run -d -p 9411:9411 openzipkin/zipkin

```

  

Then to access zipkin server of your registered microservices:

  

```

http://127.0.0.1:9411/zipkin/

```

  

Before going through the steps, microservices to be started in the following order:

  

- Service Registry
- Config Server
- Topup
- Hystrix
- API Gateway

  

**Running steps as follows:**

  

There are two ways to run the microservices:

  

- Docker containers

- Executing java jar files

  

**For docker way:**

We need to create the docker image first & to do so:

  

Navigate to every microservice root directory and run the following command:

```

docker build -t charging:latest .

```

Then to verify your image is successfully created run the following command:

```

docker images

```

If you find your image with the name **charging** or whatever the name was named then it's successfully created ;)

  

Now we need to run our created image in a container by running the following command

  

```

docker run -p 8761:8761 charging

```

Please note that i chose port :8761 as this is the default port of service registry microservice to run on and i mapped it to the same port to be run over docker . You can change it to whatever available port you like as long as its not used by another container.

  
  

------------

  

Once you see the microservice up and running

  

1- Run the following command:

```

mvn clean install package

```

  

This command shall run the maven to delete the target directory and start building the project to be packaged in the form of jar as configured in *pom.xml* file

  

  

2- Navigate to **target** generated after running the above maven command, then you shall find a file named **charging-0.0.1-SNAPSHOT.jar**

  

  

3- While you're inside the target directory, run the following command

  

```

java -jar charging-0.0.1-SNAPSHOT.jar

```

  
  

  

4- Theres another way other than the above third command, by navigating to your project directory and run:

  

```

  

mvn spring-boot:run

  

```

  

  

5- If you want to run the test cases you can execute the following command:

  

  

mvn test

  

6- To test the APIs you can use the postman collection in the same directory hierarchy

**Postman Collection**

  

  

## Further enhancement which could be done more

  

### 1- Add test coverage through the following:

 
Add the following plugin to your pom.xml
  

    <reporting>
        <plugins>
    	    <plugin>
    	    <groupId>org.apache.maven.plugins</groupId>
    	    <artifactId>maven-surefire-report-plugin</artifactId>
    	    </plugin>
    	    <plugin>
    	    <groupId>org.apache.maven.plugins</groupId>
    	    <artifactId>maven-jxr-plugin</artifactId>
    	    </plugin>
        </plugins>
    </reporting>

  

Then Run the following command:

mvn site

### 2- Adding support of having wallets with different currencies for each wallet instead of USD only