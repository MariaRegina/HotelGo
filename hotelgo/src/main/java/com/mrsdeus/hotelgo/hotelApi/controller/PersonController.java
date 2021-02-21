package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.entities.Person;
import com.mrsdeus.hotelgo.hotelApi.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/person")
public class PersonController {

    private IPersonService service;

    public PersonController(IPersonService service) {
        this.service = service;
    }

    @GetMapping("/listPerson")
    public List<Person> listPerson(){
        System.out.println(StreamSupport.stream(service.findAll().spliterator(), false).collect(Collectors.toList()));
        return StreamSupport.stream(service.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Person> findPerson(@PathVariable("id") UUID id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person){
        service.save(person);
    }
}
