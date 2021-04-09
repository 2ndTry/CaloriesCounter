package com.alexeymiroshnikov.caloriescounter.util.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
