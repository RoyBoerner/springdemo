package de.rboerner.springdemo.rest;

import de.rboerner.springdemo.domain.Person;
import de.rboerner.springdemo.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello from spring Boot";
    }

    @GetMapping("/persons")
    @Transactional(readOnly = true)
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

}
