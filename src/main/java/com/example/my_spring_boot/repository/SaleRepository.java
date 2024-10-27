package com.example.my_spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.my_spring_boot.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    // @Query("select s from Sale s join s.saleItems si where si.active = true")
    // List<Sale> findAllActive();
}
