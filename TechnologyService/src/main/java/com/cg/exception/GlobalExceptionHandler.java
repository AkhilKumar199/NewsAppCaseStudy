package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value(value="${data.exception.msg}")
    private String msg;

    @ExceptionHandler(value = TechnologyAlreadyExists.class)
    public ResponseEntity<String> ArticleAlreadyExists(TechnologyAlreadyExists dap){
            return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
    }

    @Value(value="${data.exception.msg1}")
    private String msg1;

    @ExceptionHandler(value = TechnologyIdNotFound.class)
    public ResponseEntity<String> ArticleIdNotFound(TechnologyIdNotFound dap){
            return new ResponseEntity<String>(msg1, HttpStatus.CONFLICT);

}


}