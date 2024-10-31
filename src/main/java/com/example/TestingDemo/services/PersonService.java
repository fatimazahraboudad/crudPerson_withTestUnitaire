package com.example.TestingDemo.services;

import com.example.TestingDemo.entities.Person;

import java.util.List;

public interface PersonService {


    List<Person> getAllPerson();
    Person addPerson(Person person);
    Person getById(Integer id);
    Person updatePerson(Person person);
    Person deletePerson(Person person);
}
