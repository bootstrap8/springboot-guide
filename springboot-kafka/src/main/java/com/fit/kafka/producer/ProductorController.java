package com.fit.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-06-18
 */
@RestController
public class ProductorController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 指定在1分区发送内容
     */
    @RequestMapping("/test")
    public String show() {
        kafkaTemplate.send("testTopic", "1", "你好");
        return "发送成功";
    }

}