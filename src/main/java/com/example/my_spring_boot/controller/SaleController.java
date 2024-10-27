package com.example.my_spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_spring_boot.dto.SaleDto;
import com.example.my_spring_boot.service.SaleService;


@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<SaleDto> findAll() {
        return saleService.findAll();
    }

    @GetMapping("{id}")
    public SaleDto getById(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }
}
