# Spring Boot 2.0 Demo

This is my little playground application. It demonstrates the following features.

* JPA, using
    * an opinionated in-memory DB H2 setup 
    * Project Lombok data classes
    * auto generated repositories
* static content serving
    * using webjars for Bootstrap, jQuery & Co
* REST
* Caching
* Task scheduling
* JMS messaging
* Metrics & Monitoring via Actuator
    * including an own health indicator
* Testing

## Build and Run

```
$ mvn package
$ java -jar target/springdemo-0.0.1-SNAPSHOT.jar
$ open 'http://localhost:8080'
```

## Setting Properties

A Spring Boot application comes with a ready to use configuration chain.
So you may set properties via Java system properties.

```
$ java -Dserver.port=8081 -Dspring.cache.type=none -jar target/springdemo-0.0.1-SNAPSHOT.jar 
```

... or via OS Environment.

```
$ export SERVER_PORT=8081
$ export SPRING_CACHE_TYPE=none
$ java -jar target/springdemo-0.0.1-SNAPSHOT.jar 
```

## Documentation Links

* http://start.spring.io/
* https://docs.spring.io/spring/docs/current/spring-framework-reference/
* https://docs.spring.io/spring-boot/docs/current/reference/html/
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
* https://projectlombok.org/
* https://www.webjars.org/