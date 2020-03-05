package com.fit.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-03-05
 */
@Slf4j
@Component
public class MyEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }


    //@PostConstruct不能被listener接收,是因为listener注册在bean实例化之后
    @PostConstruct
    public void setUp() {
        publisher.publishEvent(new MyEvent("SetUp"));
    }
}
