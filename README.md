Spring Framework
---
This is a comprehensive programming model and configuration model for morden java-based enterprise application. This framework is very modular and lightweighted as you can use various features individually into your existing applications. Think of this framework is an alternative to [EJB]() but it has ability to replace or even work along with EJB model.  Some of the features of Spring framework are:

* Dependency Injection using Spring Core container.
* Aspect-Oriented Programming including Spring's declarative transaction management.
* Spring MVC web application and RESTful web service framework. 
* Fundamental support for JDBC, JPA, JMS...
* Authentication and Authorization using Spring Security. 

ref: http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/overview.html

Spring Boot
---

This is the way to build new spring application quickly. Getting started with application is fast without much boilerplate code. There is a good amount of convention over configuration. You can run application using java -jar as standalone or continue with war deployment into container. There are multiple way to start/seed your application. [SPRING INITIALIZR](https://start.spring.io/) is one coolest way to get started quick. You select your build system (maven/gradle), choose spring boot version and just project artifacts and dependencies. Then just download your starter project. Other way to start is also using [spring boot cli]() Or Check out [my-spring-boot]() example created manually with following steps:

1. Create a project folder called **my-spring-boot** and add the following pom.xml file.
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.bhochhi</groupId>
    <artifactId>my-spring-boot</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.2.RELEASE<</version>
    </parent>
   </project>
 ```

2. This is simple maven project which is just empty yet but should compile and packaged well. Now we need to add dependencies depending upon what kind of app we are going to create. Spring-boot provides a number of "Starter POMs", a set of convient dependency descriptors that can be included in your application. It really make easy to add jars into your classpath. Any dependencies we needed that spring boot might have, can be imported using starter poms. In fact __spring-boot-starter-parent__ in our pom.xml is already a starter pom, that provides useful maven defaults. Let's say if we want to create web application then _spring-boot-starter-web__ is starter poms we want to include into your pom. So, add the following dependency into your pom.xml
 ```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
 ```
  One important convention to be noted: every starter pom follow a similar naming pattern: __spring-boot-starter-*__, where * is a particular type of application. checkout this [link](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter-poms) to find what starters are provided by Spring Boot.

3. Let's write some code, into the src/main/java folder and name it HelloWorld.java
 ```java
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
 ```
 * 

4. fdfd


####working with Spring Boot CLI







Deployment Strategy for web application built using Spring Boot
---
https://spring.io/blog/2014/03/07/deploying-spring-boot-applications

Spring MVC
---



Spring-security
----
Spring Security is a framework that focuses on providing both authentication and authorization to java application. Authentication is the process of establishing a principal who they claim to be( a "principle" generally means a user, device or some other systems which can perform an action in your application). "Authorization" refers to the process of deciding whether a principal is allowed to perform an action within your application. In many J2EE application, authentication is done by the container and authorization is at application level. However with spring-security, you can all your security features within your application making it easy portable.

At an authentication level, Spring Security supports:
* HTTP BASIC authentication
* HTTP Digest authentication
* LDAP
* Form-based authentication
* OpenID authentication 
* Java Authentication and Authorization Service (JAAS)
* JEE container authetication( so you can still use Container Managed Authentication if desired)
* Kerberos
* Java Open Source Single Sign on (JOSSO)
* Grails
* And many more...

With regards to authorization, there are three main areas of interest: authorizing web requests. authorizing whether methods can be invoked, and authorizing access to individual access to individual domain object instances. 

To get started, let create a spring mvc web app and then add spring-security to secure certain pages. [Here](https://github.com/bhochhi/spring-guide/tree/master/examples/spring-security) is the final version of web application that integrates spring security for demostration. Also checkout [spring](http://spring.io/guides/gs/securing-web/) for the details of this demo. 




http://www.tutorialspoint.com/spring/spring_architecture.htm
http://spring.io/docs
