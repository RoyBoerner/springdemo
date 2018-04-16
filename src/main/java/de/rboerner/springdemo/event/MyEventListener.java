package de.rboerner.springdemo.event;

import de.rboerner.springdemo.jms.MyAppEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MyEventListener {

    private Logger logger = LoggerFactory.getLogger(MyEventListener.class);

    @Async
    @EventListener(condition = "#myAppEvent.priority != 0")
    public void handle(MyAppEvent myAppEvent) throws InterruptedException {
        logger.info("handle async: {}", myAppEvent);
        TimeUnit.SECONDS.sleep(5);
        logger.info("done: {}", myAppEvent);
    }

    @EventListener(condition = "#myAppEvent.priority == 0")
    public void handleSync(MyAppEvent myAppEvent) throws InterruptedException {
        logger.info("handle sync: {}", myAppEvent);
        TimeUnit.SECONDS.sleep(5);
        logger.info("done: {}", myAppEvent);
    }

}
