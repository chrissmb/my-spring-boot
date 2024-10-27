package com.example.my_spring_boot.dto;

import java.util.List;

import lombok.Data;

@Data
public class SaleDto {

    private List<SaleItemDto> saleItemsDtos;
}
