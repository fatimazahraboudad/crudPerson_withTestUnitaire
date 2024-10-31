package com.example.TestingDemo.repositories;

import com.example.TestingDemo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
    //Spring data jpa  will automatically provide implementation for it when using existsBy{fieldName}
    boolean existsById(Integer id);
}