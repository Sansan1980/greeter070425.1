package com.skypro.greeter0704251.service;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class HelloService {

    private  Random random;
    //private final Random random = new Random();
    public HelloService(Random random) {
        this.random = random;
    }

    public String randomHello() {
        return switch (random.nextInt(1, 5)) {
            case 1-> "Hello, ";
            case 2-> "Privet, ";
            case 3-> "Salyt, ";
            default -> "Hi, ";
        };
    }
}
