package com.example.order;

import com.example.order.data.DeliveryRequest;
import java.net.URI;
import org.bouncycastle.mime.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private final RestTemplate rest;

    public OrderController(RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping("/")
    public String getOrder() {
        URI uri = URI.create("http://localhost:8081/delivery");
        DeliveryRequest req = new DeliveryRequest("1004L", "seoul");

        String response = rest.postForObject(uri, req, String.class);
        return "[order-service] :: 의 주문 :: " + response;
    }
}
