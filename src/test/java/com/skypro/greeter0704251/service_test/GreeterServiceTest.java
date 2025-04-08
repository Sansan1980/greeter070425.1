package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.GreeterService;
import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GreeterServiceTest {
    private final HelloService mockHelloService = mock(HelloService.class);

    //private final GreeterService greeterService = new GreeterService(new HelloService());
    // работало до создания и иньекции в GreeterService  класса HelloService
    private final GreeterService greeterService = new GreeterService(mockHelloService);

    @Test
    @DisplayName(" Позитивный сценарий метода whenNameCorrectReturnHello")
    public void whenNameCorrectReturnHello() {
    when(mockHelloService.randomHello()).thenReturn("Hello, ");
        String result = greeterService.greeter("Johan");
        Assertions.assertEquals("Hello, Johan", result);
    }
    @Test
    @DisplayName(" Негативный  сценарий метода whenNameNullReturnAnonimous")
    public void whenNameNullReturnAnonimous() {
        when(mockHelloService.randomHello()).thenReturn("Hello, ");
        String result = greeterService.greeter(null);
        Assertions.assertEquals("Hello, Anonimous", result);
    }
    @Test
    @DisplayName(" Негативный  сценарий метода whenNameIsBlankReturnAnonimous")
    public void whenNameIsBlankReturnAnonimous() {
        when(mockHelloService.randomHello()).thenReturn("Hello, ");
        String result = greeterService.greeter("");
        Assertions.assertEquals("Hello, Anonimous", result);
    }

}
