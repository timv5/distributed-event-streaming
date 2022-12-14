package com.streaming.consumer.service;

import com.streaming.consumer.config.StaticConfig;
import com.streaming.consumer.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = StaticConfig.TOPIC, groupId = StaticConfig.GROUP, containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(Message message) {
        LOGGER.info("Message received: " + message.toString());
    }

}

