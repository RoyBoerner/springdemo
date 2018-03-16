package de.rboerner.springdemo.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    // This demonstrates how to access property values
    @Value("${info.app.name}")
    private String appName;

    @Scheduled(initialDelay = 15000, fixedDelay = 5000)
    public void doSomeWork() throws InterruptedException {
        logger.info("run task: {}", appName);
        TimeUnit.SECONDS.sleep(10);
    }

}
