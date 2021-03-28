package com.jalasoft.compiler.model.exception;

import com.jalasoft.compiler.common.exception.CompilerException;

/**
 * @author HP
 * @version 1.1
 */
public class CommandException extends CompilerException {
    private static final String MESSAGE = "Invalid command";

    public CommandException(String currentMessage) {
        super(currentMessage);
    }

    public  CommandException(String currenMessage, Throwable ex) {
        super(currenMessage, ex);
    }

    public CommandException(Throwable ex) {
        super(MESSAGE, ex);
    }
}
