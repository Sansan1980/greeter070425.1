package com.skypro.greeter0704251.controller;

import com.skypro.greeter0704251.service.GreeterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {
    private final GreeterService greeterService;

    public GreeterController(GreeterService greeterService) {
        this.greeterService = greeterService;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", required = false) String name) {
        return greeterService.greeter(name);
    }
}
