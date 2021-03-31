package com.jalasoft.compiler.common.configuration;

import com.jalasoft.compiler.common.constant.PropertyConstant;
import com.jalasoft.compiler.common.exception.InvalidDataException;
import javafx.beans.property.Property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
/**
 * @author HP
 * @version 1.1
 */
class PropertyHandler {
    private static PropertyHandler propertyHandler;
    private static Properties properties;

    private final static  String SEPARATOR = ",";

    private PropertyHandler() throws InvalidDataException {
        try {
            this.properties = new Properties();
            this.properties.load(getClass().getClassLoader().getResourceAsStream(PropertyConstant.CONFIGURATION_FILE));
            System.out.println(this.properties.toString());
        } catch (IOException ex) {
            throw new InvalidDataException(ex);
        }
    }

    public static PropertyHandler getInstance() throws InvalidDataException {
        if (propertyHandler == null) {
            propertyHandler = new PropertyHandler();
        }
        return propertyHandler;
    }

    public String getValueAsString(String key) {
       return this.properties.getProperty(key);
    }

    public List<String> geValueAsList(String key) {
        String value = this.getValueAsString(key);
        return new ArrayList<>(Arrays.asList(
                value.split(SEPARATOR)
        ));
    }
}
