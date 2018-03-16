package de.rboerner.springdemo.service;

import de.rboerner.springdemo.domain.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Cacheable("persons")
    List<Person> findByLastName(String lastName);

}
