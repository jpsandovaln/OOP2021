package com.jalasoft.compiler.controller;

import com.jalasoft.compiler.model.Execute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HP
 * @version 1.1
 */
@RestController
public class ExecuteController {
    @PostMapping("/hello")
    public String sayHello(@RequestParam(value = "lang") String lang,
                           @RequestParam(value = "version") String version,
                           @RequestParam(value = "file") MultipartFile file) {
        //return "hello";
        System.out.println(lang);
        System.out.println(version);

        Execute ex = new Execute();
        return ex.run();
    }

}
