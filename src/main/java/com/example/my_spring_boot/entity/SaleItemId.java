package com.example.my_spring_boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class SaleItemId {

    @Column(name = "sale_id")
    private Long saleId;

    private Integer sequence;
}
