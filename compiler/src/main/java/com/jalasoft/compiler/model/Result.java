package com.jalasoft.compiler.model;

/**
 * @author HP
 * @version 1.1
 */
public class Result {
    private String pid;
    private String result;

    public Result(String pid, String result) {
        this.pid = pid;
        this.result = result;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
