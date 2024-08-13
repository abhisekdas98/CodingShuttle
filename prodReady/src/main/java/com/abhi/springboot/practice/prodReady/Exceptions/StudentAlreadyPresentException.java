package com.abhi.springboot.practice.prodReady.Exceptions;

public class StudentAlreadyPresentException extends RuntimeException{

    public StudentAlreadyPresentException(String message){
        super(message);
    }
}
