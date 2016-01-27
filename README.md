Spring Framework
---
This is a comprehensive programming model and configuration model for morden java-based enterprise application. This framework is very modular and lightweighted as you can use various features individually into your existing applications. Think of this framework is an alternative to EJB() but it has ability to replace or even work along with EJB model.  Some of the features of Spring framework are:

* Dependency Injection using Spring Core container.
* Aspect-Oriented Programming including Spring's declarative transaction management.
* Spring MVC web application and RESTful web service framework. 
* Fundamental support for JDBC, JPA, JMS...
* Authentication and Authorization using Spring Security. 
* 
ref: http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/overview.html

Spring Boot
---

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
