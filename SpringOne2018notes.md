SpringOne Platform 2018 . 
---  
* Spring Boot 2
    * Two ways : https://spring.io/img/homepage/diagram-boot-reactor.svg 
      * Reactive stack--> Spring webFlux: Mono and Flux--> netty, servlet 3.1+ --> even loop
      * Servlet stack--> Spring MVC... --> tomcat, multi threaded--> RestTemplate
      
* WebClient vs RestTemplate
   ```java
   WebClient client3 = WebClient
        .builder()
          .baseUrl("http://localhost:8080")
          .defaultCookie("cookieKey", "cookieValue")
          .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
          .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
        .build();
 	```
  ```java
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl  = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response  = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
    ```  
* Reactive Stream :  
      - to standardize asynchronous stream processing with non-blocking  back-pressure-->  
      - to govern the exchange of stream data across an asynchronous boundary
      - 4 API: Publisher, Subscriber, Subscription and Processor    
      - Implementations:    RxJava2, Spring 5 Reactor , Akka, MongoDB, Elastic, Kafka, ...                                                                                                                                                                                                                                                                                                                                                                                                                 
      - Stream-->tips: don't land the flight unless you need it. list.stream().... 
      
* Serverless event driver architecture:
    - lamda function, azure function, Knative... 
* Unit testing
   * Junit 5>> .      
       - Exception verification . 
           ```java
           @Test(expected = IllegalArgumentException.class)
           public void shouldThrowException() throws Exception {
               Task task = buildTask();
               LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
               task.execute(oneHourAgo);
           }
           Vs
           @Test
           void shouldThrowException() throws Exception {
               Task task = buildTask();
               LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
               assertThrows(IllegalArgumentException.class,
                            () -> task.execute(oneHourAgo));
           }
           ```
       - Multiple Test Runners in a class . 
       - Nested Test: @Nested . 
       - Naming Tests: @DisplayName("In plain readable sentence") .    
       - Assumptions: assumpTrue, assumpFalse, assumpThat...  
            ```java
            @Test
             void exitIfTrueIsFalse() {
             assumeFalse(this::truism);
             System.exit(1);
             }
             private boolean truism() {
             return true;
             }
            ```
        - Lambda Support . 
        - Parameterized Tests . 

   * AssertJ ==> http://joel-costigliola.github.io/assertj/index.html .  
   * BDD approach.... then >> groovy testing using spock framework is King.  
   * Spring: WebTestClient, @WebFluxTest, Spring MockMvc,  
      
* Spring Router 5
   ```java @Bean
    RouterFunction<ServerResponse> getAllEmployeesRoute() {
      return route(GET("/employees"), 
        req -> ok().body(
          employeeRepository().findAllEmployees(), Employee.class));
    }
    ```
* Intellicode AR/VR/ML IDE

* Spring initializer in vscode, eclipse and intellij

* Actuator
        predefined endpoints in 2.x Actuator:  
        - *auditevents*: Exposes audit events information for the current application.  
        - *beans*: Displays a complete list of all the Spring beans in your application.  
        - *conditions*: Shows the conditions that were evaluated on configuration and auto-configuration classes and the reasons why they did or did not match.  
        - *configprops*: Displays a collated list of all @ConfigurationProperties.  
        - *env*: Exposes properties from Spring’s ConfigurableEnvironment.  
        - *flyway*: Shows any Flyway database migrations that have been applied.  
        - *health*: Shows application health information.  
        - *httptrace*: Displays HTTP trace information (by default, the last 100 HTTP request-response exchanges).  
        - *info*: Displays arbitrary application info.  
        - *loggers*: Shows and modifies the configuration of loggers in the application.  
        - *liquibase*: Shows any Liquibase database migrations that have been applied.  
        - *metrics*: Shows metrics information for the current application.  
        - *mappings*: Displays a collated list of all @RequestMapping paths.  
        - *scheduledtasks*: Displays the scheduled tasks in your application.  
        - *sessions*: Allows retrieval and deletion of user sessions from a Spring Session-backed session store. Not available when using Spring Session’s support for reactive web applications.  
        - *shutdown*: Lets the application be gracefully shutdown. It's the only endpoint that's not enable by default.  
        - *threaddump*: Performs a thread dump. 
        
* Spring Security
   
    * Servlet . 
      - Automatic password storage upgrades through UserDetailsPasswordService . 
      - OAuth 2.0 Client: Customizable Authorize and Token requests . 
      - OAuth 2.0 Resource Server - support for JWT-encoded bearer tokens . 
      - Added OAuth2 WebClient integration . 
      - CSRF support for excluding certain requests  
      - Added Support for Feature Policy . 
      - A modern look-and-feel for the default log in page . 
    * webflux
      - Automatic password storage upgrades through ReactiveUserDetailsPasswordService . 
      - Added OAuth2 support .   
      - Added CORS support . 
      - Added support for the following HTTP headers . 
        - Content Security Policy . 
        - Feature Policy . 
        - Referrer Policy  
        - Redirect to HTTPS . 
      - Improvements for @AuthenticationPrincipal . 
      
* Apache Geode 
   - https://github.com/bhochhi/geode-guide/wiki/Apache-Geode 
   
   
(workflowy)[https://workflowy.com/#/4fea0ceb7302]
