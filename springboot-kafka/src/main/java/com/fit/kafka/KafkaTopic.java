package com.fit.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-06-18
 */
@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic batchTopic() {
        return new NewTopic("testTopic", 8, (short) 1);
    }
}