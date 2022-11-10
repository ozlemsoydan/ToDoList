package com.ozlemaglar.ToDoList.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//401
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ResourceAutorizedException extends RuntimeException{

    public ResourceAutorizedException(String message) {
        super(message);
    }
}
