package com.jalasoft.compiler.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author HP
 * @version 1.1
 */
public class Execute {
    public String run() {
        String command = "\"C:\\Program Files\\Java\\jdk1.8.0_251\\bin\\javac\" D:\\code2021\\HelloWorld.java && \"C:\\Program Files\\Java\\jdk1.8.0_251\\bin\\java\" -cp D:\\code2021\\ HelloWorld";
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command + "\"");
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
