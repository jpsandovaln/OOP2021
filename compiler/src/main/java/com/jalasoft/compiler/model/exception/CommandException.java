package com.jalasoft.compiler.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class CommandException extends Exception {
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
