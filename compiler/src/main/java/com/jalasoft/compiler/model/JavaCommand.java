package com.jalasoft.compiler.model;

import com.jalasoft.compiler.model.command.ICommandBuilder;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class JavaCommand implements ICommandBuilder {
    private static final String JAVA_COMPILER = "javac ";
    private static final String JAVA_EXECUTE = "java ";
    private static final String JAVA_CLASS_PATH = "-cp ";
    private static final String JAVA_AND = " && ";
    private static final String JAVA_SPACE = " ";

    public String buildCommand(JavaParameter parameter) throws Exception {
        StringBuilder command = new StringBuilder();
        command.append(parameter.getJavaFolder())
                .append(JAVA_COMPILER)
                .append(parameter.getJavaFile().getAbsoluteFile())
                .append(JAVA_AND)
                .append(parameter.getJavaFolder())
                .append(JAVA_EXECUTE)
                .append(JAVA_CLASS_PATH)
                .append(JAVA_SPACE)
                .append(parameter.getJavaFile().getParent())
                .append(JAVA_SPACE)
                .append(FilenameUtils.getBaseName(parameter.getJavaFile().getName()));
        if (command.toString().isEmpty()) {
            throw new Exception("Invalid command.");
        }
        return command.toString();
    }
}
