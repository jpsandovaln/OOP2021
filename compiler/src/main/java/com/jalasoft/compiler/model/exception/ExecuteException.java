package com.jalasoft.compiler.model.exception;


/**
 * @author HP
 * @version 1.1
 */
public class ExecuteException extends Exception {
    public ExecuteException(String message, Throwable ex) {
        super(message, ex);
    }

    public ExecuteException(String message) {
        super(message);
    }
}
