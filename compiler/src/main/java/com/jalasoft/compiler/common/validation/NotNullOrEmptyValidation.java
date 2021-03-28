package com.jalasoft.compiler.common.validation;

import com.jalasoft.compiler.common.exception.InvalidDataException;

/**
 * @author HP
 * @version 1.1
 */
public class NotNullOrEmptyValidation implements IValidationStrategy {

    private String value;
    private String field;

    public NotNullOrEmptyValidation(String field, String value) {
        this.field = field;
        this.value = value;
    }
    @Override
    public void validate() throws InvalidDataException {
        if (this.value == null || this.value.isEmpty()) {
            throw new InvalidDataException("invalid data on field = " + this.field);
        }
    }
}
