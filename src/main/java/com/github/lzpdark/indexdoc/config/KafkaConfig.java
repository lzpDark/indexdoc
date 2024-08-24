package com.github.lzpdark.indexdoc.config;

import com.github.lzpdark.indexdoc.utils.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author lzp
 */
@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(Constants.TOPIC_RESOURCE_TASK)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
