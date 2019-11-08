package com.fit.h2.user;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-11-08
 */
@Slf4j
public class Poster {

    @PostConstruct
    public void setup() {
        log.info("{} setup successfully", "Poster");
    }

    public void say() {
        log.info("say hello to the world!");
    }

}
