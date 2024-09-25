package com.example.my_spring_boot.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ErrorDto {

    private String code;
    private String message;
    private LocalDate date;
}
