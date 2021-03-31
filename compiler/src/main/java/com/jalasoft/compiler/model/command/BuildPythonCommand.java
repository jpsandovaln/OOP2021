package com.jalasoft.compiler.model.command;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class BuildPythonCommand {
    private String pythonPath;
    private File file;

    public BuildPythonCommand(String pythonPath, File file) {
        this.pythonPath = pythonPath;
        this.file = file;
    }

    public String getPythonCommand() {
        return pythonPath + "python " + file.getAbsolutePath();
    }
}
