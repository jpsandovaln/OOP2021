package com.jalasoft.compiler.controller.request;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HP
 * @version 1.1
 */
public class RequestParam {
    private String lang;
    private String version;
    private MultipartFile file;

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
        if (this.lang.isEmpty()) {
            throw new Exception("invalid lang");
        }
        if (!"java".equals(lang)) {
            throw new Exception("invalid lang");
        }
        if (version.isEmpty()) {
            throw new Exception("invalid version");
        }
        if (!"1.8".equals(version)) {
            throw new Exception("invalid version");
        }
        if (file.isEmpty()) {
            throw new Exception("invalid File");
        }
    }
}
