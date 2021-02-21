package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.database.GuestRepository;
import com.mrsdeus.hotelgo.hotelApi.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/guest/listGuest")
    public List<Guest> findAllGuest(){
        return StreamSupport.stream(guestRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
