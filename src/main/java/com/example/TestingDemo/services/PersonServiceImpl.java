package com.example.TestingDemo.services;

import com.example.TestingDemo.entities.Person;
import com.example.TestingDemo.repositories.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepo repo;

    @Override
    public List<Person> getAllPerson() {
        return repo.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        return repo.save(person);
    }

    @Override
    public Person getById(Integer id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Person updatePerson(Person person) {
        Person person1 = repo.findById(person.getPersonId()).orElseThrow(RuntimeException::new);
        person1.setPersonCity(person.getPersonCity());
        person1.setPersonName(person.getPersonName());
        return repo.save(person1);
    }

    @Override
    public Person deletePerson(Person person) {
       repo.delete(person);
       return person;
    }


}
