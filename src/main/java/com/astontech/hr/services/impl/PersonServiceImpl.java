package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Person;
import com.astontech.hr.repositories.PersonRepository;
import com.astontech.hr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> listAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Iterable<Person> saveListOfPersons(Iterable<Person> personList) {
        return personRepository.save(personList);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }
}
