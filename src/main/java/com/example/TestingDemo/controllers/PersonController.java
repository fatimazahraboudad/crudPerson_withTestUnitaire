package com.example.TestingDemo.controllers;

import com.example.TestingDemo.entities.Person;
import com.example.TestingDemo.services.PersonService;
import com.example.TestingDemo.services.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping("/persons/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/persons")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<Person> deletePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.deletePerson(person), HttpStatus.OK);
    }
}
