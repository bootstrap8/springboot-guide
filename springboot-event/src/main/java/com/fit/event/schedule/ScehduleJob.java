package com.fit.event.schedule;

import com.fit.event.MyEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-30
 */
@Slf4j
@Component
public class ScehduleJob {


    @Autowired
    private MyEventPublisher myEventPublisher;

    @Scheduled(cron = "0/5 * * * * *")
    public void first() {
        log.info("execute job <0 0 0/1 * * ?>");
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void testInitialDelay() {
        log.info("job delay=1000, rate=5000");
        myEventPublisher.setUp();
    }
}
