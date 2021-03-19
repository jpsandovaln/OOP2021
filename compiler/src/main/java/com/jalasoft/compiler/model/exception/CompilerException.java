package com.jalasoft.compiler.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class CompilerException extends Exception {
    private final static String GENERAL_MESSAGE = "Compiler Error";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status = "400";

    public CompilerException() {
        super(GENERAL_MESSAGE);
    }

    public CompilerException(String currentMessage){
        super(currentMessage);
    }
    public CompilerException(Throwable ex) {
        super(GENERAL_MESSAGE, ex);
    }

    public CompilerException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
}
