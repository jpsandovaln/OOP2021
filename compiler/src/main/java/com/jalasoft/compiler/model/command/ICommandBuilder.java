package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;
import com.jalasoft.compiler.model.parameter.Parameter;

public interface ICommandBuilder {
    String buildCommand(Parameter parameter) throws CommandException, ParameterInvalidException;
    /*static JavaCommand getJavaCommand() {
        return new JavaCommand();
    }*/
}
