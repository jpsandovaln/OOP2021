package com.jalasoft.compiler.model.parameter;

import com.jalasoft.compiler.model.exception.ParameterInvalidException;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class PythonParameter extends Parameter {
    private String pythonFolder;

    public PythonParameter(File file, String pythonFolder) {
        super(file);
        this.pythonFolder = pythonFolder;
    }

    public String getPythonFolder() {
        return pythonFolder;
    }

    public void setPythonFolder(String pythonFolder) {
        this.pythonFolder = pythonFolder;
    }

    @Override
    public void validate() throws ParameterInvalidException {
        if (this.pythonFolder == null || this.pythonFolder.isEmpty()) {
            throw new ParameterInvalidException();
        }
        File pythonFolderPath = new File(this.pythonFolder);
        if (!pythonFolderPath.isDirectory() || pythonFolderPath.isHidden()) {
            throw new ParameterInvalidException("javaFolder", this.pythonFolder);
        }
        if (this.file == null || !this.file.isFile() || this.file.isHidden()) {
            throw new ParameterInvalidException("invalid file");
        }
    }
}
