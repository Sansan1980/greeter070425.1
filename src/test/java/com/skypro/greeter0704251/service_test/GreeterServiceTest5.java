package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.GreeterService;
import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GreeterServiceTest5 {
    // В данном варианте мы делаем Мок класса Рандом(Не модульное , а косвенное тестирование
    //  и зависимости между классамив) и в моках меняем поведение оперируя его значениями(Цифрами) в методе
    // randomMock.nextInt класса HelloService проходя сквозь класс GreeterService
    // и его  метод greeter().

    private Random randomMock = mock(Random.class);
    private final HelloService helloService = new HelloService(randomMock);
    private final GreeterService greeterService = new GreeterService(helloService);

    @Test
    @DisplayName("Позитивный сценарий метода greet whenNameCorrect")
    public void whenNameCorrect() {
        when(randomMock.nextInt(1, 5)).thenReturn(1);
        String result = greeterService.greeter("Johan");
        Assertions.assertEquals("Hello, Johan",result);
    }
    @Test
    @DisplayName("Негативный сценарий метода greet whenNameIsBlank")
    public void whenNameIsBlank() {
        when(randomMock.nextInt(1, 5)).thenReturn(2);

        String result = greeterService.greeter(" ");
        Assertions.assertEquals("Privet, Anonimous",result);
    }
    @Test
    @DisplayName("Негативный сценарий метода greet whenNameNull")
    public void whenNameNull() {
        when(randomMock.nextInt(1, 5)).thenReturn(3);
        String result = greeterService.greeter(null);
        Assertions.assertEquals("Salyt, Anonimous",result);
    }
}
