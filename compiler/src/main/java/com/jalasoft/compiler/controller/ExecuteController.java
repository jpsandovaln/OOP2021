package com.jalasoft.compiler.controller;

import com.jalasoft.compiler.model.Execute;
import com.jalasoft.compiler.model.JavaCommand;
import com.jalasoft.compiler.model.JavaParameter;
import com.jalasoft.compiler.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
        if (lang.isEmpty()) {
            return "invalid lang";
        }
        if (!"java".equals(lang)) {
            return "invalid lang";
        }
        if (version.isEmpty()) {
            return "invalid version";
        }
        if (!"1.8".equals(version)) {
            return "invalid version";
        }
        if (file.isEmpty()) {
            return "invalid File";
        }
        try {
            Files.createDirectories(Paths.get("project/"));
            Path path = Paths.get("project/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File javaFile = new File(path.toString());

            String javaPath = "D:\\code2021\\OOP2021\\thirdParty\\java\\jdk1.8.0_251\\bin\\";

            Execute ex = new Execute();
            JavaCommand javaCommand = new JavaCommand();

            JavaParameter javaParameter = new JavaParameter(javaPath, javaFile);
            String command = javaCommand.buildCommand(javaParameter);

            Result result = ex.run(command);
            return result.getResult();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
