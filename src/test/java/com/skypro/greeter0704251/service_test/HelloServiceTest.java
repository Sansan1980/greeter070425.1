package com.skypro.greeter0704251.service_test;

import com.skypro.greeter0704251.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTest {

    @Mock
    Random random;
    @InjectMocks
    HelloService helloService;

    @Test
    public void whenRandomReturnsOne_ThenHelloServiceReturnsHello() {

        Mockito.doReturn(1).when(random).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Hello, ",helloService.randomHello());
    }
    @Test
    public void whenRandomReturnsTwo_ThenHelloServiceReturnsPrivet() {

        Mockito.doReturn(2).when(random).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Privet, ",helloService.randomHello());
    }
    @Test
    public void whenRandomReturnsThree_ThenHelloServiceReturnsSalyt() {

        Mockito.doReturn(3).when(random).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Salyt, ",helloService.randomHello());
    }
    @Test
    public void whenRandomReturnsFoure_ThenHelloServiceReturnsHi() {

        Mockito.doReturn(4).when(random).nextInt(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Assertions.assertEquals("Hi, ",helloService.randomHello());
    }
}
