package com.example.candorbackend.common.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PingController {
    @GetMapping("/api/v1/ping")
    Map<String, Boolean> ping() {
        return Map.of("ok",true);
    }


}
