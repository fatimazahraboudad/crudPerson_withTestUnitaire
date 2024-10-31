package com.example.TestingDemo.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRepoTest {

    @Id
    private Integer personId;
    private String personName;
    private String personCity;
}
