package com.jalasoft.compiler.controller.services;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileServiceTest {
    @Test
    public void testPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] classArray = new Class<?>[2];
        classArray[0] = String.class;
        classArray[1] = String.class;

        FileService fileService = new FileService();
        Method fileServiceMethod = FileService.class.getDeclaredMethod("getFilePath", classArray);
        fileServiceMethod.setAccessible(true);

        Path expected = Paths.get("D:\\xyz\\EjemploJava7.java");
        Path result = (Path) fileServiceMethod.invoke(fileService, "EjemploJava7.java", "D:/xyz/");
        assertEquals(expected, result);

    }

}