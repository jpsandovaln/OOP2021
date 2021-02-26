package com.jalasoft.compiler.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 * @version 1.1
 */
@RestController
public class ExecuteController {
    @PostMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
