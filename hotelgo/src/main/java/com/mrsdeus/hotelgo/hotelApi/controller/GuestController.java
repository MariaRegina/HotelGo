package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.entities.Guest;
import com.mrsdeus.hotelgo.hotelApi.service.IGuestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private IGuestService service;

    public GuestController(IGuestService service) {
        this.service = service;
    }

    @GetMapping("/listGuest")
    public List<Guest> findAllGuest(){
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Guest> findGuest(@PathVariable("id")UUID id){
        return service.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public Guest findByName(@PathVariable("name")String name){
        return service.findByPersonName(name);
    }

    @PostMapping("/add")
    public void addGuest(Guest guest){
        service.save(guest);
    }

}
