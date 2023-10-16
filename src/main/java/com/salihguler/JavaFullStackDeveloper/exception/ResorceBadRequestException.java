package com.salihguler.JavaFullStackDeveloper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//404:Kötü İstek
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ResorceBadRequestException extends RuntimeException {

    public ResorceBadRequestException(String message) {
        super(message);
    }
}
