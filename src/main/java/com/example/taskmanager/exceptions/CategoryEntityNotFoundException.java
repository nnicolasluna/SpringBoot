package com.example.taskmanager.exceptions;

public class CategoryEntityNotFoundException extends RuntimeException{
    public CategoryEntityNotFoundException(String entityName, String uuid) {
        super(String.format("Entity: %s not found with uuid(s)=%s", entityName, uuid));
    }
}
