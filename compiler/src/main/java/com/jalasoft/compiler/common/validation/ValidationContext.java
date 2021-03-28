package com.jalasoft.compiler.common.validation;

import com.jalasoft.compiler.common.exception.InvalidDataException;

import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class ValidationContext {
    List<IValidationStrategy> validationStrategies;

    public ValidationContext(List<IValidationStrategy> validationStrategies) {
        this.validationStrategies = validationStrategies;
    }

    public void validation() throws InvalidDataException {
        for (IValidationStrategy strategy : this.validationStrategies) {
            strategy.validate();
        }
    }
}
