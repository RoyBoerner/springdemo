package de.rboerner.springdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/index-rs")
    public String index() {
        return "Hello from Spring Boot REST Controller";
    }

}
