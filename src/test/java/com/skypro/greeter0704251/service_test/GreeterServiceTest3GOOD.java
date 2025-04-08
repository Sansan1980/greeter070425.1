package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.GreeterService;
import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GreeterServiceTest3GOOD {
    private HelloService mockHelloService;
    private GreeterService greeterService;

    //Можно использовать аннотацию @BeforEach для облегчения записи кода  и
    // читаемости кодаю для создания моков в каждом методе теста такой код
    // позволяет создавать перед каждым тестом заново  новый обьект мока и сервиса.
    @BeforeEach
    public void setUp() {
        mockHelloService = mock(HelloService.class);
        greeterService = new GreeterService(mockHelloService);
    }

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

        when(mockHelloService.randomHello()).thenReturn("Privet, ");
        String result = greeterService.greeter(null);
        Assertions.assertEquals("Privet, Anonimous", result);
    }

    @Test
    @DisplayName(" Негативный  сценарий метода whenNameIsBlankReturnAnonimous")
    public void whenNameIsBlankReturnAnonimous() {

        when(mockHelloService.randomHello()).thenReturn("Hi, ");
        String result = greeterService.greeter("");
        Assertions.assertEquals("Hi, Anonimous", result);
    }

}
