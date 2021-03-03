package com.jalasoft.compiler.model;

import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author HP
 * @version 1.1
 */
public class Execute {
    private String javaCompiler = "javac ";
    private String javaExecute = "java ";
    private String javaClassPath = "-cp ";
    private String javaAnd = " && ";
    private String javaSpace = " ";

    public String run(String javaFolder, File javaFile) {
        // String command = "\"C:\\Program Files\\Java\\jdk1.8.0_251\\bin\\javac\" D:\\code2021\\HelloWorld.java && \"C:\\Program Files\\Java\\jdk1.8.0_251\\bin\\java\" -cp D:\\code2021\\ HelloWorld";
        StringBuilder command = new StringBuilder();
        command.append(javaFolder)
                .append(javaCompiler)
                .append(javaFile.getAbsoluteFile())
                .append(javaAnd)
                .append(javaFolder)
                .append(javaExecute)
                .append(javaClassPath)
                .append(javaSpace)
                .append(javaFile.getParent())
                .append(javaSpace)
                .append(FilenameUtils.getBaseName(javaFile.getName()));
        System.out.println(command.toString());
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command.toString() + "\"");
            builder.redirectErrorStream(true);

            Process process = builder.start();
            process.waitFor();

            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append((char) reader.read());
            }
            return result.toString();

        } catch (IOException ex) {
            return  ex.getMessage();
        } catch (InterruptedException ex) {
            return ex.getMessage();
        }

    }
}
