package com.fit.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;

import java.util.Optional;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-06-18
 */
@Configuration
public class KafkaConsumer {

    //配置topic和分区,可以配置多个
    //topic为队列名称
    //partitions表示值的的分区，这里指定了0和2分区
    //partitionOffsets表示详细的指定分区，partition表示那个分区，initialOffset表示Offset的初始位置
    @KafkaListener(topicPartitions =
            {@TopicPartition(topic = "testTopic",
                    partitions = {"0", "2"},
                    partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "4"))
            }
    )
    public void consumer(ConsumerRecord consumerRecord) {
        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMassage.isPresent()) {
            Object o = kafkaMassage.get();
            System.out.println("接收到的消息是：" + o);
        }

    }

}
