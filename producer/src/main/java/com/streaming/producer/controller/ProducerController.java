package com.streaming.producer.controller;

import com.streaming.producer.config.StaticConfigs;
import com.streaming.producer.model.Message;
import com.streaming.producer.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    private final MessageProducer messageProducer;

    @Autowired
    public ProducerController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/message")
    public Response produceMessage() {
        this.messageProducer.publish(StaticConfigs.TOPIC, new Message());
        return Response.ok().build();
    }

}
