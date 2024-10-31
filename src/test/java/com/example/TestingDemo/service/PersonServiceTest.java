package com.example.TestingDemo.service;


import com.example.TestingDemo.entities.Person;
import com.example.TestingDemo.repositories.PersonRepo;
import com.example.TestingDemo.services.PersonServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

// Main class
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;
    //When using Mockito Use @InjectMocks to inject
    //Mocked beans to following class
    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Test
    void getAllPerson()
    {
        //given
        Person person= new Person( 1,"fati","casa");
        Person person2= new Person(2,"oussama","casa");
        //When
        given(personRepo.findAll())
                .willReturn(List.of(person,person2));
        var  personList = personServiceImpl.getAllPerson();
        //Then
        //Make sure to import assertThat From org.assertj.core.api package
        assertThat(personList).isNotNull();
        assertThat(personList.size()).isEqualTo(2); // Assertion incorrecte pour test

    }


    @Test
    void addPerson()
    {
        //given
        Person person= new Person( 3,"hajar","casa");
        //When
        when(personRepo.save(person))
                .thenReturn(person);
        Person addedPerson = personServiceImpl.addPerson(person);
        //Then
        //Make sure to import assertThat From org.assertj.core.api package
        assertThat(addedPerson).isNotNull();
        assertThat(addedPerson.getPersonName()).isEqualTo("hajar");
        assertThat(addedPerson.getPersonCity()).isEqualTo("media");
        verify(personRepo, times(1)).save(person);

    }

    @Test
    void getByIdPerson() {
        Person person = new Person(1, "fati", "casa");

        given(personRepo.findById(1)).willReturn(Optional.of(person));

        Person personrecieved = personServiceImpl.getById(1);

        assertThat(personrecieved).isNotNull();
        assertThat(personrecieved.getPersonName()).isEqualTo("fati");
        assertThat(personrecieved.getPersonCity()).isEqualTo("casa");
        verify(personRepo, times(1)).findById(1);
    }

    @Test
    void updatePerson() {

        Person personToUpdate = new Person(1, "fati", "casa");
        Person personUpdated = new Person(1, "fati-zahra", "casa");

        given(personRepo.findById(1)).willReturn(Optional.of(personToUpdate));
        when(personRepo.save(personUpdated)).thenReturn(personUpdated);

        Person person = personServiceImpl.updatePerson(personUpdated);

        assertThat(person).isNotNull();
        assertThat(person.getPersonName()).isEqualTo("fati-zahra");
        assertThat(person.getPersonCity()).isEqualTo("casa");
        verify(personRepo, times(1)).save(personUpdated);


    }

    @Test
    void deletePerson() {

        Person person = new Person(1, "fati", "casa");
        given(personRepo.findById(1)).willReturn(Optional.of(person));

        Person personToDelete = personServiceImpl.getById(person.getPersonId());
        assertThat(person).isNotNull();
        assertThat(person.getPersonId()).isEqualTo(personToDelete.getPersonId());
        assertThat(person.getPersonName()).isEqualTo("fati");
        assertThat(person.getPersonCity()).isEqualTo("casa");

        personServiceImpl.deletePerson(personToDelete);
        verify(personRepo,times(1)).delete(person);

    }

}