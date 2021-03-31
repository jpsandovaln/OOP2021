package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;

/**
 * @author HP
 * @version 1.1
 */
public class CommandFactory {

    private final static String JAVA = "java";
    private final static String PYTHON = "python";

    public static ICommandBuilder getCommand(String lang) throws CommandException {
        if (JAVA.equals(lang)) {
            return new JavaCommand();
        }
        if (PYTHON.equals(lang)) {
            return new PythonCommandAdapter();
        }
        throw new CommandException("Invalid language");
    }
}
