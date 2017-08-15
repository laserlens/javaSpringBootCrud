package com.astontech.hr.repositories;

import com.astontech.hr.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Integer> {
    List<Person> findAll();
}
