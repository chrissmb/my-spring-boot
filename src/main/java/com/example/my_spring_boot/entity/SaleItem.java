package com.example.my_spring_boot.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class SaleItem {

    @Id
    private SaleItemId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "sale_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "product_id", referencedColumnName = "id")
    private Product product;

    private int quantity;

    private BigDecimal amount;

    private Boolean active;
}
