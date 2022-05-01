package com.example.web;

import com.example.MessageSender;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final MessageSender messageSender;

    @PostMapping
    public String delivery(@RequestBody DeliveryRequest request) {

        String userId = request.getUserId();
        String address = request.getAddress();

        messageSender.send("배송 문자 발송 요청2");

        return "[delivery-service] userId: " + userId + " address: " + address + " 배송 요청 완료";
    }
}
