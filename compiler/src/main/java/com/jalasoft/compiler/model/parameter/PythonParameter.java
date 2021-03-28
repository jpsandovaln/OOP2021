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
public class PythonParameter extends Parameter {
    private String pythonFolder;

    public PythonParameter(String pythonFolder, File file) {
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
    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("python folder", this.pythonFolder));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();

        /*if (this.pythonFolder == null || this.pythonFolder.isEmpty()) {
            throw new ParameterInvalidException();
        }
        File pythonFolderPath = new File(this.pythonFolder);
        if (!pythonFolderPath.isDirectory() || pythonFolderPath.isHidden()) {
            throw new ParameterInvalidException("javaFolder", this.pythonFolder);
        }
        if (this.file == null || !this.file.isFile() || this.file.isHidden()) {
            throw new ParameterInvalidException("invalid file");
        }*/
    }
}
