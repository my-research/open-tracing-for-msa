package com.example.api.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    @PostMapping("/delivery")
    public String delivery(@RequestBody DeliveryRequest request) {
        String userId = request.getUserId();
        String address = request.getAddress();

        return "[delivery-service] userId: " + userId + " address: " + address + " 배송 요청 완료";
    }
}
