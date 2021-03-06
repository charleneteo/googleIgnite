GOOGLE IGNITE COLAB
---------------------
Introduction
------------

Backend of the web application built using Java, Spring Boot, JPA Hibernate and Google Cloud SQL

Requirements
 ------------
 
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `src.main.java.com.example.demo.GoogleApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

This app will run on host 8082

In addition, the database is linked to Google Cloud Platform.
