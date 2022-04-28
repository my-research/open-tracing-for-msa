package com.example.order;

import com.example.order.data.DeliveryRequest;
import java.net.URI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zipkin2.reporter.AsyncReporter;

@RestController
public class OrderController {

    private final RestTemplate rest;
    private final URI uri = URI.create("http://localhost:8081/delivery");

    public OrderController(RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping("/")
    public String getOrder() {
        DeliveryRequest req = new DeliveryRequest("1004L", "seoul");
        String response = rest.postForObject(uri, req, String.class);
        return "[order-service] :: 의 주문 :: " + response;
    }
}
