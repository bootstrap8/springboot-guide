package com.fit.h2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-11
 */
@Slf4j
@Component
public class ConfigPrinter {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void logProfile() throws UnknownHostException {
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();
        log.info("SpringBoot-H2 Environment active profiles : {}", Arrays.asList(activeProfiles));
        log.info("SpringBoot-H2 Environment default profiles : {}", Arrays.asList(defaultProfiles));
        log.info("SpringBoot-H2 property foo : {}", environment.getProperty("foo"));
        log.info("SpringBoot-H2 property spring.cloud.zookeeper.enabled : {}", environment.getProperty("spring.cloud.zookeeper.enabled"));
        log.info("SpringBoot-H2 property spring.cloud.zookeeper.connect : {}", environment.getProperty("spring.cloud.zookeeper.connect"));

        log.info("jar.out.application.key - jar.out.application.key:{}", environment.getProperty("jar.out.application.key"));
        log.info("config.application.key - config.application.key:{}", environment.getProperty("config.application.key"));
        log.info("jar.out.application.dev.key - jar.out.application.dev.key:{}", environment.getProperty("jar.out.application.dev.key"));

        log.info("------------------------------------------------------------");
        InetAddress address = InetAddress.getLocalHost();
        log.info("localhost.ip={}", address.getHostAddress());
        log.info("h2.var.replace={}", environment.getProperty("h2.var.replace"));

    }
}
