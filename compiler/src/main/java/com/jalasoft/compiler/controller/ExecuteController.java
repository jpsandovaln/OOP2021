package com.jalasoft.compiler.controller;

import com.jalasoft.compiler.controller.component.Properties;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.response.ErrorResponse;
import com.jalasoft.compiler.controller.response.OKResponse;
import com.jalasoft.compiler.controller.response.Response;
import com.jalasoft.compiler.controller.services.FileService;
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

import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private FileService fileService;

    @PostMapping("/hello")
    public ResponseEntity<Response> sayHello(RequestParam params) {
        try {
            params.validate();
            File javaFile = this.fileService.store(params.getFile());
            String javaPath = this.properties.getJavaPath(params.getVersion());
            Execute ex = new Execute();
            ICommandBuilder<JavaParameter> javaCommand = new JavaCommand();
            String command = javaCommand.buildCommand(new JavaParameter(javaPath, javaFile));
            Result result = ex.run(command);
            return ResponseEntity.ok(new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResult(), result.getPid()));
        } catch (ParameterInvalidException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()));
        } catch (CommandException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>("400", ex.getMessage()));
        } catch (ExecuteException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>("400", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>("400", ex.getMessage()));
        }
    }
}
