package com.udea.kbtflights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(long id) {
        super("Entity with id " + id + " not found");
    }

    public ModelNotFoundException(String message) {
        super(message);
    }
}
