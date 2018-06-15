package de.rboerner.springdemo.timer;

import io.micrometer.core.instrument.Metrics;
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
    public void doSomeWork() {
        logger.info("run task: {}", appName);
        http://localhost:8080/actuator/metrics/scheduled.tasks.somework?tag=outcome:success
        Metrics.counter("scheduled.tasks.somework", "outcome", "success").increment();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            logger.error("caught exception", e);
            Metrics.counter("scheduled.tasks.somework", "outcome", "fail").increment();
        }
    }

}
