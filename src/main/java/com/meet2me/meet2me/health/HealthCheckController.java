package com.meet2me.meet2me.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping()
    public ResponseEntity<String> healthCheck() {
         return ResponseEntity.ok("Health Check OK");
    }
}