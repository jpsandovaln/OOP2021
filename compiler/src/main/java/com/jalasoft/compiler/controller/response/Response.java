package com.jalasoft.compiler.controller.response;

/**
 * @author HP
 * @version 1.1
 */
public class Response {
    private String status;
    private String message;
    private String error;

    public Response(String status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
