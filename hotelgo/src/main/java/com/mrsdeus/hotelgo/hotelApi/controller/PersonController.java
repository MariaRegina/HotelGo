package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.dto.PersonDto;
import com.mrsdeus.hotelgo.hotelApi.entities.Person;
import com.mrsdeus.hotelgo.hotelApi.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<PersonDto> listPerson(){
        return StreamSupport.stream(service.findAll().spliterator(), false).map(PersonDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonDto findPerson(@PathVariable("id") UUID id){
        return new PersonDto(service.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person){
        service.save(person);
    }
}
