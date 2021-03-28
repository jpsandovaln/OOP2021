package com.jalasoft.compiler.model.exception;


import com.jalasoft.compiler.common.exception.CompilerException;

/**
 * @author HP
 * @version 1.1
 */
public class ExecuteException extends CompilerException {
    public ExecuteException(String message, Throwable ex) {
        super(message, ex);
    }

    public ExecuteException(String message) {
        super(message);
    }
}
