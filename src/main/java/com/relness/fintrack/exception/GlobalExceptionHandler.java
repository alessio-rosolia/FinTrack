package com.relness.fintrack.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.relness.fintrack.dto.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleBadRequest(RuntimeException re){
        ErrorMessage body = new ErrorMessage();
        body.setMessage(re.getMessage());
        body.setTimestamp(LocalDateTime.now());        

        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    } 

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleInternalError(Exception ex){
        ErrorMessage body = new ErrorMessage();
        body.setMessage(ex.getMessage());
        body.setTimestamp(LocalDateTime.now());  

        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
