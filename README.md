# Spring Boot 2.0 Demo

This is my little playground application. It demonstrates the following features.

1. What do we have out of the box?
    1. very quick project start-up (via start.spring.io)
    1. ready to use parent POMs
    1. Maven plug-in produces runnable fat JAR
    1. embedded servlet engine
    1. serving static content
        1. supporting webjars for Bootstrap, jQuery & Co 
1. REST
1. Configuration
    1. ready to use configuration chain (see Setting Properties below)
    1. type save config
1. Metrics & Monitoring via Actuator
    1. including an own health indicator
    1. app info (Git commit id)
1. JPA, using
    1. an opinionated in-memory DB H2 setup 
    1. auto generated repositories
    1. transactions
1. Testing
1. Caching
1. Task scheduling
1. Application events
    1. Async feature
1. JMS messaging

## Some Notes

This demo uses [Project Lombok](https://projectlombok.org/features/all) data classes to reduce boiler plate code.

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

... or via application properties

```
$ java -jar target/springdemo-0.0.1-SNAPSHOT.jar --server.port=8081 --spring.cache.type=none 
```

... and of course via config file...

## Documentation Links

* https://spring.io
* https://start.spring.io/
* https://docs.spring.io/spring/docs/current/spring-framework-reference/
* https://docs.spring.io/spring-boot/docs/current/reference/html/
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
* https://projectlombok.org/
* https://www.webjars.org/

### Spring vs EJB

* https://www.future-processing.pl/blog/another-one-on-spring-framework-and-enterprise-javabeans/

### Some Slides

* https://speakerdeck.com/olivergierke/spring-framework-5-and-spring-boot-2-dot-0


