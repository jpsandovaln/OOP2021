package com.jalasoft.compiler.model.command;

import com.jalasoft.compiler.model.exception.CommandException;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;
import com.jalasoft.compiler.model.parameter.JavaParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class JavaCommandTest {

    private final static String JAVA_FOLDER8 = "D:/code2021/OOP2021/thirdParty/java/jdk1.8.0_251/bin/";
    private final static String JAVA_FOLDER8_INVALID = "D:/code2021/OOP2021111/thirdParty/java/jdk1.8.0_251/bin/";
    private final static String JAVA_FOLDER7 = "D:/code2021/OOP2021/thirdParty/java/jdk1.7.0_80/bin/";

    private final static String JAVA_FILE8 = "src/test/resources/java_files/EjemploJava8.java";
    private final static String JAVA_FILE7 = "src/test/resources/java_files/EjemploJava7.java";

    @Test
    public void buildCommandJava8() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(JAVA_FOLDER8,new File(JAVA_FILE8));
        JavaCommand command = new JavaCommand();
        String result = command.buildCommand(javaParameter);
        String expected = "D:/code2021/OOP2021/thirdParty/java/jdk1.8.0_251/bin/javac D:\\code2021\\OOP2021\\compiler\\src\\test\\resources\\java_files\\EjemploJava8.java && D:/code2021/OOP2021/thirdParty/java/jdk1.8.0_251/bin/java -cp  src\\test\\resources\\java_files EjemploJava8";
        assertEquals("valid command", expected, result);
    }

    @Test
    public void buildCommandJava7() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(JAVA_FOLDER7, new File(JAVA_FILE7));
        JavaCommand command = new JavaCommand();
        String result = command.buildCommand(javaParameter);
        String expected = "D:/code2021/OOP2021/thirdParty/java/jdk1.7.0_80/bin/javac D:\\code2021\\OOP2021\\compiler\\src\\test\\resources\\java_files\\EjemploJava7.java && D:/code2021/OOP2021/thirdParty/java/jdk1.7.0_80/bin/java -cp  src\\test\\resources\\java_files EjemploJava7";
        assertEquals("valid command java 7", expected, result);
    }

    @Test(expected = ParameterInvalidException.class)
    public void buildCommandNullParameter() throws ParameterInvalidException, CommandException {
        JavaCommand command = new JavaCommand();
        command.buildCommand(null);
    }

    @Test(expected = ParameterInvalidException.class)
    public void buildCommandInvalidFolder() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(JAVA_FOLDER8_INVALID, new File(JAVA_FILE8));
        JavaCommand javaCommand = new JavaCommand();
        javaCommand.buildCommand(javaParameter);
    }

    @Test(expected = ParameterInvalidException.class)
    public  void buildCommandInvalidParameter() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(null, null);
        JavaCommand command = new JavaCommand();
        command.buildCommand(javaParameter);
    }
}