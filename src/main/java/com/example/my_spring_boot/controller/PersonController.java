package com.example.my_spring_boot.controller;

import com.example.my_spring_boot.entity.Person;
import com.example.my_spring_boot.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping
    private List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("{id}")
    private Person getPersonById(@PathVariable Long id) {
        LOGGER.info("getPersonById {}", id);
        return personService.getPersonById(id);
    }

    @PostMapping
    private Person save(@RequestBody Person person) {
        LOGGER.info("save Person {}", person);
        return personService.save(person);
    }
}
