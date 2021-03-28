package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;
import com.jalasoft.compiler.model.parameter.Parameter;

public interface ICommandBuilder<T> {
    String buildCommand(T parameter) throws CommandException, InvalidDataException;
    /*static JavaCommand getJavaCommand() {
        return new JavaCommand();
    }*/
}
