package com.jalasoft.compiler.common.validation;

import com.jalasoft.compiler.common.exception.InvalidDataException;

public interface IValidationStrategy {
    void validate() throws InvalidDataException;
}
