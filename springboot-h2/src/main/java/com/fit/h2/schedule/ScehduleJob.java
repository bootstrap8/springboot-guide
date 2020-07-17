package com.fit.h2.schedule;

import lombok.extern.slf4j.Slf4j;
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

    //@Scheduled(cron = "0/5 * * * * *")
    public void first() {
        log.info("execute job <0/5 * * * * *>");
    }

    @Scheduled(initialDelay = 1000, fixedRate = 30000)
    public void testInitialDelay() {
        log.info("job delay=1000, rate=5000");
    }


    @Scheduled(cron = "0 0 */1 * * *")
    public void testRecycle() {
        log.info("execute job <0 0 */1 * * *>");
    }
}
