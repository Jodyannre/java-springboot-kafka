package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.internals.Topic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {


    Map<String, String> configurations = new HashMap<>();
    configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete -> borra msj || compact -> mantiene el mas actual
    configurations.put(TopicConfig.RETENTION_MS_CONFIG,"86400000"); // Tiempo de retención de msg -> por defecto 1
    configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG,"1073741824"); // Tamaño máximo del segmento - 1gb por defecto
    configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012"); // Tamaño máximo de msg - Por defecto 1mb

        return TopicBuilder.name("mi-primer-topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
