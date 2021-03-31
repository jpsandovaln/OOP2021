package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.parameter.PythonParameter;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommandAdapter implements ICommandBuilder<PythonParameter> {
    @Override
    public String buildCommand(PythonParameter parameter) throws CommandException, InvalidDataException {
        BuildPythonCommand buildPythonCommand = new BuildPythonCommand(parameter.getPythonFolder(), parameter.getFile());
        return buildPythonCommand.getPythonCommand();
    }
}
