package com.fit.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-03-05
 */
@Slf4j
@Component
public class MyEventListener {

    @EventListener
    public void onEvent(ApplicationEvent event) {
        if (event instanceof MyEvent) {
            log.info("/- meet myEvent");
        } else {
            log.info("/- meet {}", event.getClass().getSimpleName());
        }
    }
}
