package com.example.my_spring_boot.exception;

public class PersonNameNotInformedException extends RuntimeException {

    public PersonNameNotInformedException() {
        super("Person name not informed.");
    }

    public String getCode() {
        return "P0001";
    }
}
