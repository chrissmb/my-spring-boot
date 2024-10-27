package com.example.my_spring_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.my_spring_boot.dto.SaleDto;
import com.example.my_spring_boot.mapper.SaleMapper;
import com.example.my_spring_boot.repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<SaleDto> findAll() {
        return SaleMapper.mapSales(saleRepository.findAll());
    }

    public SaleDto getSaleById(Long id) {
        return SaleMapper.map(saleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Sale not found")));
    }
}
