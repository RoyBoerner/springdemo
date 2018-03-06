package de.rboerner.springdemo.service;

import de.rboerner.springdemo.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByLastName(String lastName);

}
