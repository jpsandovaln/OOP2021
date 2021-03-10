package com.jalasoft.compiler.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class ParameterInvalidException extends Exception {
    private final static String GENERAL_MESSAGE = "Invalid Parameter";
    private final static String FIELD_MESSAGE = "Invalid value = %s, on field = %s";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status = "400";

    public ParameterInvalidException() {
        super(GENERAL_MESSAGE);
    }

    public ParameterInvalidException(String currentMessage){
        super(currentMessage);
    }
    public ParameterInvalidException(Throwable ex) {
        super(GENERAL_MESSAGE, ex);
    }

    public ParameterInvalidException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public ParameterInvalidException(String field, String value) {
        super(String.format(FIELD_MESSAGE, value, field));
    }

}
