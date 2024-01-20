package com.example.taskmanager.exceptions;

public class StatusEntityNotFoundException extends  RuntimeException {
    public StatusEntityNotFoundException(String entityName, String uuid) {
        super(String.format("Entity: %s not found with uuid(s)=%s", entityName, uuid));
    }
}
