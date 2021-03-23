package com.jalasoft.compiler.controller.services;

import com.jalasoft.compiler.controller.component.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author HP
 * @version 1.1
 */
@Service
public class FileService {
    @Autowired
    private Properties properties;

    public File store(MultipartFile file) throws Exception {
        try {
            Path path = this.getFilePath(file.getOriginalFilename(), this.properties.getProjectFolder());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return new File(path.toString());
        } catch (IOException ex) {
            throw new Exception("File error", ex);
        }
    }

    private Path getFilePath(String fileName, String projectPath) throws Exception {
        try {
            Files.createDirectories(Paths.get(projectPath));
            return Paths.get(projectPath + fileName);
        } catch (IOException ex) {
            throw new Exception("Path error", ex);
        }
    }
}
