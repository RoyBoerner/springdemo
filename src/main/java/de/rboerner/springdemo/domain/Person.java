package de.rboerner.springdemo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {

    @Id
    @SequenceGenerator(name = "person_gen", sequenceName = "person_seq", initialValue = 100)
    @GeneratedValue(generator = "person_gen")
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

}
