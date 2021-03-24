package com.jalasoft.compiler.model.parameter;

import com.jalasoft.compiler.model.exception.CommandException;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class ParameterFactory {
    private final static String JAVA = "java";
    private final static String PYTHON = "python";

    public static Parameter getCommand(String lang, String path, File file) throws CommandException {
        if (JAVA.equals(lang)) {
            return new JavaParameter(path, file);
        }
        if (PYTHON.equals(lang)) {
            return new PythonParameter(path, file);
        }
        throw new CommandException("Invalid language");
    }
}
