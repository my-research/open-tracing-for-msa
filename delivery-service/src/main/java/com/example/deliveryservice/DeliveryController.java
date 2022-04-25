package com.example.deliveryservice;

import com.example.deliveryservice.data.DeliveryRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    @PostMapping("/delivery")
    public String delivery(@RequestBody DeliveryRequest request) throws Exception {
        String userId = request.getUserId();
        String address = request.getAddress();
        throw new Exception();
        // return "[delivery-service] userId: " + userId + " address: " + address + " 배송 요청 완료";
    }
}
