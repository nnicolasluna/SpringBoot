package com.example.taskmanager.exceptions;

import java.util.Date;
import java.util.Map;

public class StatusFieldValidationException extends StatusException {
    private Map<String, String> fieldErrors;


    public StatusFieldValidationException(Date timestamp, String message, String path, Integer status, Map<String, String> fieldErrors) {
        super(timestamp, message, path, status);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
