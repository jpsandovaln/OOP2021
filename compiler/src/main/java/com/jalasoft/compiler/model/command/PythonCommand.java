package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.parameter.Parameter;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommand implements ICommandBuilder {
    @Override
    public String buildCommand(Parameter parameter) throws Exception {
        return "ipconfig";
    }
}
