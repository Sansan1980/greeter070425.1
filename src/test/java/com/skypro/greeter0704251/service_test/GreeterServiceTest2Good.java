package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.GreeterService;
import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GreeterServiceTest2Good {
    //Моккирование на уровне класса не рекомендуется (особенно если один и тот же мок (моккируемого  класса, метода ) возвращают в тестах(Hello,Privet,Hi) разный результат, нужно моккировать в
    // каждом test методе (для изоляции методов теста от возможной
    // зависимости друг от друга ю от возможного изменения и влияние
    // выдаваемого результата мока от соседнего тест метода и его резултата.)
    // и передавать мок в конструктор тестироваемого класса (new GreeterService(mockHelloService))
    @Test
    @DisplayName(" Позитивный сценарий метода whenNameCorrectReturnHello")
    public void whenNameCorrectReturnHello() {
        HelloService mockHelloService = mock(HelloService.class);
        GreeterService greeterService = new GreeterService(mockHelloService);
        when(mockHelloService.randomHello()).thenReturn("Hello, ");
        String result = greeterService.greeter("Johan");
        Assertions.assertEquals("Hello, Johan", result);
    }

    @Test
    @DisplayName(" Негативный  сценарий метода whenNameNullReturnAnonimous")
    public void whenNameNullReturnAnonimous() {
        HelloService mockHelloService = mock(HelloService.class);
        GreeterService greeterService = new GreeterService(mockHelloService);
        when(mockHelloService.randomHello()).thenReturn("Privet, ");
        String result = greeterService.greeter(null);
        Assertions.assertEquals("Privet, Anonimous", result);
    }

    @Test
    @DisplayName(" Негативный  сценарий метода whenNameIsBlankReturnAnonimous")
    public void whenNameIsBlankReturnAnonimous() {
        HelloService mockHelloService = mock(HelloService.class);
        GreeterService greeterService = new GreeterService(mockHelloService);
        when(mockHelloService.randomHello()).thenReturn("Hi, ");
        String result = greeterService.greeter("");
        Assertions.assertEquals("Hi, Anonimous", result);
    }

}
