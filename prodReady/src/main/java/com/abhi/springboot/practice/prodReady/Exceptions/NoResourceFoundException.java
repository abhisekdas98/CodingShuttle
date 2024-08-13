package com.abhi.springboot.practice.prodReady.Exceptions;

public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException(String message) {
        super(message);
    }
}
