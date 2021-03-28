package com.jalasoft.compiler.model;

import com.jalasoft.compiler.model.command.CommandFactory;
import com.jalasoft.compiler.model.command.ICommandBuilder;
import com.jalasoft.compiler.common.exception.CompilerException;
import com.jalasoft.compiler.model.execute.IExecute;
import com.jalasoft.compiler.model.parameter.ParameterFactory;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class CompileFacade {
    public static Result executeCode(String lang, String path, File file) throws CompilerException {
        IExecute ex = new IExecute.Execute();
        ICommandBuilder javaCommand = CommandFactory.getCommand(lang);
        String command = javaCommand.buildCommand(ParameterFactory.getCommand(lang, path, file));
        return ex.run(command);
    }
}
