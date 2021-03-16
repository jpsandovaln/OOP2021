package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;
import com.jalasoft.compiler.model.parameter.PythonParameter;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommand implements ICommandBuilder<PythonParameter> {
    @Override
    public String buildCommand(PythonParameter parameter) throws ParameterInvalidException {
        return "ipconfig";
    }
}
