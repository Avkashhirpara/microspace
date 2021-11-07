package com.example.circuitbreakerdemo;


import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@RestController
public class DemoController {
    private CircuitBreakerFactory factory;
    private RestTemplate rest;

    public DemoController(CircuitBreakerFactory factory, RestTemplate rest) {
        this.factory = factory;
        this.rest = rest;
    }


    @GetMapping("delay/{seconds}")
    public Map delayCall(@PathVariable int seconds){
        return factory.create("delay").run(()-> {
            return rest.getForObject("https://httpbin.org/delay/"+seconds,Map.class);
        },t -> {
            t.printStackTrace();
            Map<String,String> fallback = new HashMap<>();
            fallback.put("fall","back");
            return fallback;
        });
    }

    public Map delay(int seconds) {
        return rest.getForObject("https://httpbin.org/delay/" + seconds, Map.class);
    }

    public Supplier<Map> delaySuppplier(int seconds) {
        return () -> this.delay(seconds);
    }
}
