package com.fit.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-03-05
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}
