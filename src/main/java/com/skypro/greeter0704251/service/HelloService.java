package com.skypro.greeter0704251.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HelloService {

    private Random random;

    //private final Random random = new Random();
    public HelloService() {//Для Spring
        this.random = new Random();

    }

    public HelloService(Random random) {
        this.random = random;
    }

    public String randomHello() {
        //Такая запись Ifov тоже работает!
//        int randomValue = random.nextInt(1, 5);
//        if (randomValue == 1) {
//            System.out.println("Hello, ");
//            return "Hello, ";
//        }
//        if (randomValue == 2) {
//            System.out.println("Privet, ");
//            return "Privet, ";
//        }
//        if (randomValue == 3) {
//            System.out.println("Salyt");
//            return "Salyt, ";
//        }
//        System.out.println("Hi, ");
//        return "Hi, ";
//    }
        // Генерируем случайное число один раз
        int randomValue = random.nextInt(1, 5);

        // Используем switch для выбора строки на основе случайного числа
        String greeting = switch (randomValue) {
            case 1 -> "Hello, ";
            case 2 -> "Privet, ";
            case 3 -> "Salyt, ";
            default -> "Hi, ";
        };

        // Логируем возвращаемое значение
        System.out.println(greeting);

        return greeting;
    }
}





