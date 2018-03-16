package de.rboerner.springdemo.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class ActiveMqConfig {

    public static final String QNAME = "sample.queue";

    @Bean
    public Queue createQueue() {
        return new ActiveMQQueue(QNAME);
    }

}
