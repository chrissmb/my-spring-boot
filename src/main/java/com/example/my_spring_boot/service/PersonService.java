package com.example.my_spring_boot.service;

import com.example.my_spring_boot.entity.Person;
import com.example.my_spring_boot.exception.PersonNameNotInformedException;
import com.example.my_spring_boot.exception.PersonNotFoundException;
import com.example.my_spring_boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Transactional
    public Person save(Person person) {
        if (person.getName() == null || person.getName().isBlank()) {
            throw new PersonNameNotInformedException();
        }
        return personRepository.save(person);
    }
}
