package com.streaming.consumer.config;

import lombok.NonNull;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;

public class KafkaErrorHandler implements CommonErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaErrorHandler.class);

    @Override
    public void handleOtherException(@NonNull Exception thrownException, @NonNull Consumer<?, ?> consumer,
                                     @NonNull MessageListenerContainer container, boolean batchListener) {
        LOGGER.error(thrownException.getMessage(), thrownException);
    }
}
