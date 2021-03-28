package com.jalasoft.compiler.controller.request;

import com.jalasoft.compiler.common.validation.IValidationStrategy;
import com.jalasoft.compiler.common.validation.JavaVersionValidation;
import com.jalasoft.compiler.common.validation.LanguageValidation;
import com.jalasoft.compiler.common.validation.MultipartFileValidation;
import com.jalasoft.compiler.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.compiler.common.validation.ValidationContext;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class RequestParam {
    private String lang;
    private String version;
    private MultipartFile file;

    private final static List<String> JAVA_VERSION_LIST = Arrays.asList(
      "1.7",
      "1.8"
    );

    private final static  List<String> LANG_LIST = Arrays.asList(
      "java",
      "python"
    );

    public RequestParam(String lang, String version, MultipartFile file) {
        this.lang = lang;
        this.version = version;
        this.file = file;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void validate() throws Exception {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("lang", lang));
        validationStrategies.add(new NotNullOrEmptyValidation("version", version));
        validationStrategies.add(new MultipartFileValidation(file));
        validationStrategies.add(new LanguageValidation(lang));
        validationStrategies.add(new JavaVersionValidation(version));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
