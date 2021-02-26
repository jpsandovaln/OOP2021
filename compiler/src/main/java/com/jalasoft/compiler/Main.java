package com.jalasoft.compiler;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * @author HP
 * @version 1.1
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(Main.class, args);
    }
}
