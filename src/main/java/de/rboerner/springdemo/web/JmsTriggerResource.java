package de.rboerner.springdemo.web;

import de.rboerner.springdemo.jms.ActiveMqConfig;
import de.rboerner.springdemo.jms.MyAppEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsTriggerResource {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/jmstrigger")
    public void triggerJms() {
        jmsTemplate.convertAndSend(ActiveMqConfig.QNAME, MyAppEvent.builder().message("hello world").build());
    }

}
