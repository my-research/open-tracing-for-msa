package com.example.notificationservice;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageReceiver {

    @SqsListener("${aws.queue.name}")
    public void receiveMessage(String message, @Headers Map<String, MessageAttributeValue> sqsHeaders) {
        System.out.println("메시지 수신 완료, message = " + message);
    }
}
