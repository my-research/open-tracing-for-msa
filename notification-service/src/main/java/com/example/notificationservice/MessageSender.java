package com.example.notificationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

// @Component
//@RequiredArgsConstructor
public class MessageSender {

//    @Value("${aws.queue.name-2}")
//    private String queue;
//
//    private final QueueMessagingTemplate template;
//
//    public void send(String message) {
//        template.convertAndSend(queue, message);
//    }
}