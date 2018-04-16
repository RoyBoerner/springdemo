package de.rboerner.springdemo.web;

import de.rboerner.springdemo.jms.MyAppEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class EventTriggerResource {

    private AtomicInteger count = new AtomicInteger();

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/eventTrigger")
    public String triggerEvent(@RequestParam(required = false, defaultValue = "1") Integer prio) {
        eventPublisher.publishEvent(MyAppEvent.builder().message("test").priority(prio).build());
        return "Done " + count.addAndGet(1);
    }

}
