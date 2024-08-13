package com.abhi.springboot.practice.prodReady.advises;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {

    String errorMessage;
    HttpStatus errorStatus;

}
