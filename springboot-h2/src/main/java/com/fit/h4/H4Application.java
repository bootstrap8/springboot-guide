package com.fit.h4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-17
 */
@Slf4j
@Component
public class H4Application {

    @PostConstruct
    public void setUp(){
        log.info("setUp H4Application successfully!");
    }
}
