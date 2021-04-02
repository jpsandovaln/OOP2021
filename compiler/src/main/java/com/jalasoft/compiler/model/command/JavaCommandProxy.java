package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.parameter.JavaParameter;

import java.util.Calendar;

/**
 * @author HP
 * @version 1.1
 */
public class JavaCommandProxy implements ICommandBuilder<JavaParameter> {
    private JavaCommand javaCommand;
    private final static int HOUR = 16;

    public JavaCommandProxy() {
        this.javaCommand = new JavaCommand();
    }

    @Override
    public String buildCommand(JavaParameter parameter) throws CommandException, InvalidDataException {
        Calendar now = Calendar.getInstance();
        int currentHour = now.get(Calendar.HOUR_OF_DAY);
        System.out.println(currentHour);
        if (HOUR <= currentHour) {
            throw new InvalidDataException("Invalid Hour.");
        }
        return this.javaCommand.buildCommand(parameter);
    }
}
