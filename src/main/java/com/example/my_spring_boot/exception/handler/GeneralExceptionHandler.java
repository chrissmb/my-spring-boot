package com.example.my_spring_boot.exception.handler;

import com.example.my_spring_boot.dto.ErrorDto;
import com.example.my_spring_boot.exception.PersonNameNotInformedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(PersonNameNotInformedException.class)
    public ResponseEntity<ErrorDto> handle(PersonNameNotInformedException ex, WebRequest webRequest) {
        var error = ErrorDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .date(LocalDate.now())
                .build();
        return ResponseEntity.badRequest().body(error);
    }
}
