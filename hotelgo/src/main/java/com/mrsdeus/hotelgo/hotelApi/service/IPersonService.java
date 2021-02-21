package com.mrsdeus.hotelgo.hotelApi.service;

import com.mrsdeus.hotelgo.hotelApi.entities.Person;

import java.util.Optional;
import java.util.UUID;

public interface IPersonService {
    Iterable<Person> findAll();

    Optional<Person> findById(UUID id);

    void save(Person person);

    void deleteById(UUID id);
}
