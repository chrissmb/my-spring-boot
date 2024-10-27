package com.example.my_spring_boot.entity;

import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Sale {

    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
    @SQLRestriction("active = true")
    private List<SaleItem> saleItems;
}
