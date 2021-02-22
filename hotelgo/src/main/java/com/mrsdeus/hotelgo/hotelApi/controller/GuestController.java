package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.dto.GuestDto;
import com.mrsdeus.hotelgo.hotelApi.entities.Guest;
import com.mrsdeus.hotelgo.hotelApi.service.IGuestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public List<GuestDto> findAllGuest(){
        return StreamSupport.stream(service.findAll().spliterator(), false)
                .map(GuestDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GuestDto findGuest(@PathVariable("id")UUID id){
        return GuestDto.entityToDto(service.findById(id).orElse(null));
    }

    @GetMapping("/findByName/{name}")
    public GuestDto findByName(@PathVariable("name")String name){
        return GuestDto.entityToDto(service.findByPersonName(name));
    }

    @PostMapping("/add")
    public void addGuest(Guest guest){
        service.save(guest);
    }

}
