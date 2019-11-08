package com.fit.h2.config;

import com.fit.h2.user.Poster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-30
 */
@Configuration
public class Config {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(2);
        taskScheduler.setThreadNamePrefix("sb-job-");
        return taskScheduler;
    }

    @Bean
    @Lazy
    public Poster setup() {
        return new Poster();
    }

}
