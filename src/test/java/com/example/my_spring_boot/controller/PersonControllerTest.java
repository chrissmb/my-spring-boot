package com.example.my_spring_boot.controller;

import com.example.my_spring_boot.entity.Person;
import com.example.my_spring_boot.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

    @Test
    void testGetPersons() throws Exception {
        doReturn(instancePersons()).when(personRepository).findAll();

        mockMvc.perform(get("/person"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$").isNotEmpty()))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Maria"));
    }

    @Test
    void testGetPersonsEmpty() throws Exception {
        doReturn(Collections.emptyList()).when(personRepository).findAll();

        mockMvc.perform(get("/person"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void getPersonById() throws Exception {
        doReturn(Optional.of(person1())).when(personRepository).findById(1L);

        mockMvc.perform(get("/person/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    void getPersonByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(personRepository).getReferenceById(2L);

        mockMvc.perform(get("/person/2"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void savePerson() throws Exception {
        doReturn(person1()).when(personRepository).save(any());

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    void savePersonEmpty() throws Exception {

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value("P0001"))
                .andExpect(jsonPath("$.message").value("Person name not informed."))
                .andExpect(jsonPath("$.date").isNotEmpty());
    }

    private List<Person> instancePersons() {
        return Arrays.asList(person1(), person2());
    }

    private Person person1() {
        Person person = new Person();
        person.setId(1L);
        person.setName("John");
        person.setBirthday(LocalDate.of(1980, 5 , 12));
        return person;
    }

    private Person person2() {
        Person person = new Person();
        person.setId(2L);
        person.setName("Maria");
        person.setBirthday(LocalDate.of(2001, 7 , 9));
        return person;
    }

    private String requestBody() {
        return """
                {
                    \"name\": \"John\",
                    \"birthday\": \"1980-05-12\"
                }
                """;
    }
}