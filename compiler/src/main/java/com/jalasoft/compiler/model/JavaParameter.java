package com.jalasoft.compiler.model;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class JavaParameter {
    private String javaFolder;
    private File javaFile;

    public JavaParameter(String javaFolder, File javaFile) {
        this.javaFolder = javaFolder;
        this.javaFile = javaFile;
    }

    public String getJavaFolder() {
        return javaFolder;
    }

    public File getJavaFile() {
        return javaFile;
    }
}
