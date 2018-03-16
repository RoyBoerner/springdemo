package de.rboerner.springdemo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = ActiveMqConfig.QNAME, concurrency = "1-2")
    public void receive(Message<MyAppEvent> message) throws InterruptedException {
        logger.info("header: {}, payload: {}", message.getHeaders(), message.getPayload());
        TimeUnit.SECONDS.sleep(5);
    }

}
