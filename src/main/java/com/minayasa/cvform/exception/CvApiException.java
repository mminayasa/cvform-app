package com.minayasa.cvform.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CvApiException extends RuntimeException{
    private HttpStatus status;
    private String message;
}