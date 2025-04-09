package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Random;

import static com.skypro.greeter0704251.service_test.StaticRandomMock.randomMock2;
import static org.mockito.Mockito.mock;

public class HelloServiceTest3 {

    @Test
    public void whenRandomReturnsOne_ThenHelloServiceReturnsHello() {
        HelloService helloService = new HelloService(StaticRandomMock.randomMock2);
        Mockito.doReturn(1).when(randomMock2).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Hello, ", helloService.randomHello());
    }

    @Test
    public void whenRandomReturnsTwo_ThenHelloServiceReturnsPrivet() {
        HelloService helloService = new HelloService(randomMock2);
        Mockito.doReturn(2).when(randomMock2).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Privet, ", helloService.randomHello());
    }

    @Test
    public void whenRandomReturnsThree_ThenHelloServiceReturnsSalyt() {
        HelloService helloService = new HelloService(randomMock2);
        Mockito.doReturn(3).when(randomMock2).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Salyt, ", helloService.randomHello());
    }

    @Test
    public void whenRandomReturnsFoure_ThenHelloServiceReturnsHi() {
        HelloService helloService = new HelloService(randomMock2);
        Mockito.doReturn(4).when(randomMock2).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Hi, ", helloService.randomHello());
    }
}
