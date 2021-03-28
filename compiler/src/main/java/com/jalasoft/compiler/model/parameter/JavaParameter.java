package com.jalasoft.compiler.model.parameter;

import com.jalasoft.compiler.common.exception.InvalidDataException;
import com.jalasoft.compiler.common.validation.IValidationStrategy;
import com.jalasoft.compiler.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.compiler.common.validation.ValidationContext;
import com.jalasoft.compiler.model.exception.ParameterInvalidException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class JavaParameter extends Parameter{
    private String javaFolder;

    public JavaParameter(String javaFolder, File javaFile) {
        super(javaFile);
        this.javaFolder = javaFolder;
    }

    public String getJavaFolder() {
        return javaFolder;
    }

    @Override
    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("java folder", this.javaFolder));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();

        /*if (this.javaFolder == null || this.javaFolder.isEmpty()) {
            throw new ParameterInvalidException();
        }
        File javaFolderPath = new File(this.javaFolder);
        if (!javaFolderPath.isDirectory() || javaFolderPath.isHidden()) {
            throw new ParameterInvalidException("javaFolder", this.javaFolder);
        }
        if (this.file == null || !this.file.isFile() || this.file.isHidden()) {
            throw new ParameterInvalidException("invalid file");
        }*/
    }
}
