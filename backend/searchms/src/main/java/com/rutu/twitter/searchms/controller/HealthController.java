package com.rutu.twitter.searchms.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> healthStatus() {
        return Collections.singletonMap("status", "running");
    }
}
