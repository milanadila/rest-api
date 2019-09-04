package com.api.resto.pop.controller;

import com.api.resto.pop.util.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);

        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .status(404)
                        .message("Unexpected Error")
                        .errors(new String[]{e.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);

        //blok untuk mengambil nama field dan message lalu di store ke String array
        String[] errors = e.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + " " + f.getDefaultMessage())
                .toArray(String[]::new);

        //blok ini untuk mengembalikan nilai ke response entity dengan mengirim status ,message ,dan error. Jadi nanti yang muncul di swagger hanya status,message,dan errors.
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .status(403)
                        .message("Argument invalid")
                        .errors(errors)
                        .build()
                );
    }
}
