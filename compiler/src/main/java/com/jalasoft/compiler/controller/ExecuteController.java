package com.jalasoft.compiler.controller;

import com.jalasoft.compiler.controller.component.Properties;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.response.Response;
import com.jalasoft.compiler.model.Execute;
import com.jalasoft.compiler.model.command.JavaCommand;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ExecuteException;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import com.jalasoft.compiler.model.Result;
import com.jalasoft.compiler.model.command.ICommandBuilder;
import com.jalasoft.compiler.model.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
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

    @Autowired
    private Properties properties;

    @PostMapping("/hello")
    public ResponseEntity<Response> sayHello(RequestParam params) {
        try {
            params.validate();
            Files.createDirectories(Paths.get(this.properties.getProjectFolder()));
            Path path = Paths.get(this.properties.getProjectFolder() + params.getFile().getOriginalFilename());
            Files.copy(params.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File javaFile = new File(path.toString());

            String javaPath = this.properties.getJava8Path();

            Execute ex = new Execute();
            ICommandBuilder javaCommand = new JavaCommand();
            //ICommandBuilder javaCommand = ICommandBuilder.getJavaCommand();

            Parameter javaParameter = new JavaParameter(javaPath, javaFile);
            String command = javaCommand.buildCommand(javaParameter);

            Result result = ex.run(command);

            return ResponseEntity.ok(new Response("200", result.getResult(), ""));
        } catch (ParameterInvalidException ex) {
            return ResponseEntity.badRequest().body(new Response("400", "", ex.getMessage()));
        } catch (CommandException ex) {
            return ResponseEntity.badRequest().body(new Response("400", "", ex.getMessage()));
        } catch (ExecuteException ex) {
            return ResponseEntity.badRequest().body(new Response("400", "", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response("400", "", ex.getMessage()));
        }
    }
}
