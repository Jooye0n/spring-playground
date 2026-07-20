package com.jooyeon.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception e){
        //e.printStackTrace();
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
