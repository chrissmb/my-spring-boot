package com.example.my_spring_boot.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItemDto {

    private Integer sequence;

    private ProductDto productDto;

    private int quantity;

    private BigDecimal amount;
}
