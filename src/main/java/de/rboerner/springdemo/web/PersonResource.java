package de.rboerner.springdemo.web;

import de.rboerner.springdemo.domain.Person;
import de.rboerner.springdemo.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    @Transactional(readOnly = true)
    public Iterable<Person> getPersons(@RequestParam(required = false) String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            return personRepository.findAll();
        } else {
            return personRepository.findByLastName(lastName);
        }
    }

}
