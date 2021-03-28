package com.jalasoft.compiler.controller;

import com.jalasoft.compiler.controller.component.Properties;
import com.jalasoft.compiler.controller.request.RequestParam;
import com.jalasoft.compiler.controller.response.ErrorResponse;
import com.jalasoft.compiler.controller.response.OKResponse;
import com.jalasoft.compiler.controller.response.Response;
import com.jalasoft.compiler.controller.services.FileService;
import com.jalasoft.compiler.model.CompileFacade;
import com.jalasoft.compiler.common.exception.CompilerException;
import com.jalasoft.compiler.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/api/v1")
public class ExecuteController {

    @Autowired
    private Properties properties;

    @Autowired
    private FileService fileService;

    @PostMapping("/execute")
    public ResponseEntity<Response> executeCode(RequestParam params) {
        try {
            params.validate();
            File file = this.fileService.store(params.getFile());
            String path = this.properties.getJavaPath(params.getVersion());
            Result result = CompileFacade.executeCode(params.getLang(), path, file);
            return ResponseEntity.ok(new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResult(), result.getPid()));
        } catch (CompilerException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>(ex.getStatus(), ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse<String>("400", ex.getMessage()));
        }
    }
}
