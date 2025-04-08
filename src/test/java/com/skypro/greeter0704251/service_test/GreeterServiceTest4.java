package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.GreeterService;
import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GreeterServiceTest4 {
    // Здесь мы создали мок на уровне класса, но поведение  мока  будет
    // обновляться перед каждым @Test с помощью @BeforEach,
    // это упрощает запись и чтение кода, меньше строк кода , но так делать
    // нежелательно слабая (нет явной изоляции и нет явного заданного поведения мока)
    // изоляция тестов.

    private final HelloService helloService = mock(HelloService.class);
    private final GreeterService greeterService = new GreeterService(helloService);


    @BeforeEach
    void configureMock() {
        Mockito.doReturn("Privet").when(helloService).randomHello();
    }


    @Test
    @DisplayName("Позитивный сценарий метода greet whenNameCorrect")
    public void whenNameCorrect() {
        String result = greeterService.greeter("Johan");
        Assertions.assertEquals("Privet, Johan",result);
    }
    @Test//d этом тесте мы поменяли поведение мока отличное от заданного на уровне класа под @BeforEach
    @DisplayName("Негативный сценарий метода greet whenNameIsBlank")
    public void whenNameIsBlank() {
        //здесь Явно поменяли поведение мока на "Hello",
        // но изоляция сохраняется, благодаря @BeforEach
        // происходит сбрасывание мока перед каждым @Test.
        when(helloService.randomHello()).thenReturn("Hello");
        String result = greeterService.greeter(" ");
        Assertions.assertEquals("Hello, Anonimus",result);
    }
    @Test
    @DisplayName("Негативный сценарий метода greet whenNameNull")
    public void whenNameNull() {
        String result = greeterService.greeter(null);
        Assertions.assertEquals("Privet, Anonimus",result);
    }
}
