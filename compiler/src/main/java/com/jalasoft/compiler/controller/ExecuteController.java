package com.jalasoft.compiler.controller;

import com.jalasoft.compiler.controller.component.Properties;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.response.ErrorResponse;
import com.jalasoft.compiler.controller.response.OKResponse;
import com.jalasoft.compiler.controller.response.Response;
import com.jalasoft.compiler.controller.services.FileService;
import com.jalasoft.compiler.model.command.CommandFactory;
import com.jalasoft.compiler.model.exception.CompilerException;
import com.jalasoft.compiler.model.execute.IExecute;
import com.jalasoft.compiler.model.Result;
import com.jalasoft.compiler.model.command.ICommandBuilder;
import com.jalasoft.compiler.model.parameter.ParameterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

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
            File file = this.fileService.store(params.getFile());
            String path = this.properties.getJavaPath(params.getVersion());

            IExecute ex = new IExecute.Execute();
            ICommandBuilder javaCommand = CommandFactory.getCommand(params.getLang());
            String command = javaCommand.buildCommand(ParameterFactory.getCommand(params.getLang(), path, file));
            Result result = ex.run(command);

            return ResponseEntity.ok(new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResult(), result.getPid()));
        } catch (CompilerException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>(ex.getStatus(), ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>("400", ex.getMessage()));
        }
    }
}
