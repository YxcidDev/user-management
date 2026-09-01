package com.example.usermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StateController {

    @GetMapping("/state")
    public ResponseEntity<String> getState() {
        return ResponseEntity.ok("Servicio operativo");
    }
}
