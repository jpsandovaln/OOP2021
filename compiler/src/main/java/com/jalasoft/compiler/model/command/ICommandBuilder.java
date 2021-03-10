package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.parameter.Parameter;

public interface ICommandBuilder {
    String buildCommand(Parameter parameter) throws Exception;
    /*static JavaCommand getJavaCommand() {
        return new JavaCommand();
    }*/
}
