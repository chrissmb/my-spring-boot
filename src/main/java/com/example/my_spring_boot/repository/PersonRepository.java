package com.example.my_spring_boot.repository;

import com.example.my_spring_boot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
