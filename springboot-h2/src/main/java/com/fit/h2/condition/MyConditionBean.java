package com.fit.h2.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-06-03
 */
@Slf4j
@Component
@ConditionalOnProperty(prefix = "h2", name = "condition.setup", havingValue = "123")
public class MyConditionBean {

    @PostConstruct
    public void setUp() {
        StopWatch stopWatch = new StopWatch("Loader");
        stopWatch.start("MyDog");
        log.info("SetUp MyConditionBean Successfully");
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }
}
