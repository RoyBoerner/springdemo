package de.rboerner.springdemo.web;

import de.rboerner.springdemo.config.MyTypeSafeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private MyTypeSafeConfig config;

    @GetMapping("/index-rs")
    public String index() {
        return "Hello from Spring Boot REST Controller";
    }

    @GetMapping("/config")
    public MyTypeSafeConfig getConfig() {
        logger.info("get config: {}", config);
        return config;
    }
}
