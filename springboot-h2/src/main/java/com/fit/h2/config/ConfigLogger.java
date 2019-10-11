package com.fit.h2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-11
 */
@Slf4j
@Component
public class ConfigLogger {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void logProfile(){
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();
        log.info("SpringBoot-H2 Environment active profiles : {}", Arrays.asList(activeProfiles));
        log.info("SpringBoot-H2 Environment default profiles : {}", Arrays.asList(defaultProfiles));
        log.info("SpringBoot-H2 property foo : {}", environment.getProperty("foo"));
        log.info("SpringBoot-H2 property spring.cloud.zookeeper.enabled : {}", environment.getProperty("spring.cloud.zookeeper.enabled"));
        log.info("SpringBoot-H2 property spring.cloud.zookeeper.connect : {}", environment.getProperty("spring.cloud.zookeeper.connect"));
    }
}
