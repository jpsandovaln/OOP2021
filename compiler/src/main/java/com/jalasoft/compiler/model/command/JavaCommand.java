package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.command.ICommandBuilder;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import com.jalasoft.compiler.model.parameter.Parameter;
import org.apache.commons.io.FilenameUtils;

/**
 * @author HP
 * @version 1.1
 */
class JavaCommand implements ICommandBuilder<JavaParameter> {
    private static final String JAVA_COMPILER = "javac ";
    private static final String JAVA_EXECUTE = "java ";
    private static final String JAVA_CLASS_PATH = "-cp ";
    private static final String JAVA_AND = " && ";
    private static final String JAVA_SPACE = " ";

    public String buildCommand(JavaParameter parameter) throws CommandException, ParameterInvalidException {
        if (parameter == null) {
            throw new ParameterInvalidException("invalid parameter");
        }
        parameter.validate();
        StringBuilder command = new StringBuilder();
        command.append(parameter.getJavaFolder())
                .append(JAVA_COMPILER)
                .append(parameter.getFile().getAbsoluteFile())
                .append(JAVA_AND)
                .append(parameter.getJavaFolder())
                .append(JAVA_EXECUTE)
                .append(JAVA_CLASS_PATH)
                .append(JAVA_SPACE)
                .append(parameter.getFile().getParent())
                .append(JAVA_SPACE)
                .append(FilenameUtils.getBaseName(parameter.getFile().getName()));
        if (command.toString().isEmpty()) {
            throw new CommandException("Invalid command.");
        }
        return command.toString();
    }
}
