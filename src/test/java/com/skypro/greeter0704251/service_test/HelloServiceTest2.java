package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.Mockito.mock;

public class HelloServiceTest2 {
    @Test
    public void whenRandomReturnsOne_ThenHelloServiceReturnsHello() {
        Random randomMock = mock(Random.class);
        HelloService helloService = new HelloService(randomMock);
        Mockito.doReturn(1).when(randomMock).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Hello, ", helloService.randomHello());
    }

    @Test
    public void whenRandomReturnsTwo_ThenHelloServiceReturnsPrivet() {
        Random randomMock = mock(Random.class);
        HelloService helloService = new HelloService(randomMock);
        Mockito.doReturn(2).when(randomMock).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Privet, ", helloService.randomHello());
    }

    @Test
    public void whenRandomReturnsThree_ThenHelloServiceReturnsSalyt() {
        Random randomMock = mock(Random.class);
        HelloService helloService = new HelloService(randomMock);
        Mockito.doReturn(3).when(randomMock).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Salyt, ", helloService.randomHello());
    }

    @Test
    public void whenRandomReturnsFoure_ThenHelloServiceReturnsHi() {
        Random randomMock = mock(Random.class);
        HelloService helloService = new HelloService(randomMock);
        Mockito.doReturn(4).when(randomMock).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Hi, ", helloService.randomHello());
    }
}
