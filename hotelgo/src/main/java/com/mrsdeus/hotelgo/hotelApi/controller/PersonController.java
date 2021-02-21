package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.database.PersonRepository;
import com.mrsdeus.hotelgo.hotelApi.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/listPerson")
    public List<Person> listPerson(){
        System.out.println(StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(Collectors.toList()));
        return StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPerson(@PathVariable("id") UUID id){
        return personRepository.findById(id);
    }
}
