package com.astontech.hr.services;

import com.astontech.hr.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> listAllPersons ();
    Person getPersonById (Integer id);

    Person savePerson(Person person);
    Iterable<Person> saveListOfPersons(Iterable<Person> personList);

    void deletePerson(Integer id);
}
