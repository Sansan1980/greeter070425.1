package com.skypro.greeter0704251.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreeterService {
  private final HelloService helloService;

   @Autowired
    public GreeterService(HelloService helloService) {
        this.helloService = helloService;
    }

    public String greeter(String name) {
        String hello = helloService.randomHello();
        if (name == null || name.isBlank()) {
            System.out.println( hello + "Anonimous");
            return hello + "Anonimous";
        }else{
            System.out.println( hello + name);
            return hello + name;
        }
    }
}
