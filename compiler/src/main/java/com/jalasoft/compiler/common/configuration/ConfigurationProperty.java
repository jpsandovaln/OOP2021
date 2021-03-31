package com.jalasoft.compiler.common.configuration;

import com.jalasoft.compiler.common.constant.PropertyConstant;
import com.jalasoft.compiler.common.exception.InvalidDataException;

import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class ConfigurationProperty {
    public static List<String> getLanguages() throws InvalidDataException {
        return PropertyHandler.getInstance().geValueAsList(PropertyConstant.EXECUTE_LANGUAGE);
    }

    public static  String getOS() throws InvalidDataException {
        return  PropertyHandler.getInstance().getValueAsString(PropertyConstant.EXECUTE_OPERATING_SYSTEM);
    }
}
