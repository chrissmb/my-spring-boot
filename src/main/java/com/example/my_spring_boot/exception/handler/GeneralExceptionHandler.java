package com.example.my_spring_boot.exception.handler;

import com.example.my_spring_boot.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handle(IllegalArgumentException ex, WebRequest webRequest) {
        var error = ErrorDto.builder()
                .code("P0001")
                .message(ex.getMessage())
                .date(LocalDate.now())
                .build();
        return ResponseEntity.badRequest().body(error);
    }
}
