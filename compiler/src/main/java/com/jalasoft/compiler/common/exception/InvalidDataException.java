package com.jalasoft.compiler.common.exception;

import com.jalasoft.compiler.model.exception.CommandException;

/**
 * @author HP
 * @version 1.1
 */
public class InvalidDataException extends CommandException {
    private static final String MESSAGE = "Invalid data";

    public InvalidDataException(String currentMessage) {
        super(currentMessage);
    }

    public  InvalidDataException(String currenMessage, Throwable ex) {
        super(currenMessage, ex);
    }

    public InvalidDataException(Throwable ex) {
        super(MESSAGE, ex);
    }
}
