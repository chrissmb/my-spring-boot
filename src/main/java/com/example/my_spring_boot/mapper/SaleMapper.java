package com.example.my_spring_boot.mapper;

import java.util.Collections;
import java.util.List;

import com.example.my_spring_boot.dto.ProductDto;
import com.example.my_spring_boot.dto.SaleDto;
import com.example.my_spring_boot.dto.SaleItemDto;
import com.example.my_spring_boot.entity.Product;
import com.example.my_spring_boot.entity.Sale;
import com.example.my_spring_boot.entity.SaleItem;

public class SaleMapper {

    public static SaleDto map(Sale sale) {
        if (sale == null) {
            return null;
        }
        SaleDto saleDto = new SaleDto();
        saleDto.setSaleItemsDtos(mapSaleItems(sale.getSaleItems()));
        return saleDto;
    }

    public static List<SaleDto> mapSales(List<Sale> sales) {
        if (sales == null || sales.isEmpty()) {
            return Collections.emptyList();
        }
        return sales.stream().map(SaleMapper::map).toList();
    }

    private static ProductDto map(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    private static SaleItemDto map(SaleItem saleItem) {
        if (saleItem == null) {
            return null;
        }
        SaleItemDto saleItemDto = new SaleItemDto();
        saleItemDto.setAmount(saleItem.getAmount());
        saleItemDto.setProductDto(map(saleItem.getProduct()));
        saleItemDto.setQuantity(saleItem.getQuantity());
        saleItemDto.setSequence(saleItem.getId().getSequence());
        return saleItemDto;
    }

    private static List<SaleItemDto> mapSaleItems(List<SaleItem> saleItems) {
        if (saleItems == null || saleItems.isEmpty()) {
            return Collections.emptyList();
        }
        return saleItems.stream().map(SaleMapper::map).toList();
    }
}
