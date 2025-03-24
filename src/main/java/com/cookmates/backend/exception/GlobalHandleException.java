package com.cookmates.backend.exception;

import com.cookmates.backend.dto.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseMessage> dataNotFound(DataNotFoundException ex) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(false)
                .message(ex.getMessage())
                .timestamp(new Date())
                .data(null)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingDataException.class)
    public ResponseEntity<ResponseMessage> dataAlreadyExists(DataNotFoundException ex) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(false)
                .message(ex.getMessage())
                .timestamp(new Date())
                .data(null)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
