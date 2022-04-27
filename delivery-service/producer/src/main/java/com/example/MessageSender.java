package com.example;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
