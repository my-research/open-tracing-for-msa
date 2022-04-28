package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {
    @Value("${aws.queue.name}")
    private String notificationQueue;

    private final QueueMessagingTemplate template;

    public void send(Object message) {
        template.convertAndSend(notificationQueue, message);
    }
}
