package com.example.the_wild_oasis.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {


    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> exceptionHandler(Exception e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }
}
