package com.abhi.springboot.practice.prodReady.advises;

import com.abhi.springboot.practice.prodReady.Exceptions.NoResourceFoundException;
import com.abhi.springboot.practice.prodReady.Exceptions.StudentAlreadyPresentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiError> handleStudentNotFound(NoResourceFoundException exception){
        ApiError apiError = ApiError.builder()
                .errorStatus(HttpStatus.NOT_FOUND)
                .errorMessage(exception.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAlreadyPresentException.class)
    public ResponseEntity<ApiError> handleStudentAlreadyPresent(StudentAlreadyPresentException exception){
        ApiError apiError = ApiError.builder()
                .errorStatus(HttpStatus.BAD_REQUEST)
                .errorMessage(exception.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

}
