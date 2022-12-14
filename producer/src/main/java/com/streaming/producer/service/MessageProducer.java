package com.streaming.producer.service;

import com.streaming.producer.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Autowired
    public MessageProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(final String topic, final Message message) {
        try {
            LOGGER.info("Publishing message {} to topic {}", message.toString(), topic);
            this.kafkaTemplate.send(topic, message);
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
        }
    }
}
