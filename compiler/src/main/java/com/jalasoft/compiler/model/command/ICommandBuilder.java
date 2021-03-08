package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.JavaParameter;

public interface ICommandBuilder {
    String buildCommand(JavaParameter parameter) throws Exception;
}
