package com.jalasoft.compiler.controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HP
 * @version 1.1
 */
@Component
@ConfigurationProperties(prefix = "execute.java")
public class Properties {
    private String projectFolder;
    private String java8Path;
    private String java7Path;

    private final static  String JAVA_VERSION7 = "1.7";
    private final static  String JAVA_VERSION8 = "1.8";

    public String getJava7Path() {
        return java7Path;
    }

    public void setJava7Path(String java7Path) {
        this.java7Path = java7Path;
    }

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public String getJava8Path() {
        return java8Path;
    }

    public void setJava8Path(String java8Path) {
        this.java8Path = java8Path;
    }

    public String getJavaPath(String version) {
        return JAVA_VERSION7.equals(version) ? this.getJava7Path() : this.getJava8Path();
    }
}
