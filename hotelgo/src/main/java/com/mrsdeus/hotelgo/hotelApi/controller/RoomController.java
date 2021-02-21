package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.database.RoomRepository;
import com.mrsdeus.hotelgo.hotelApi.entities.Room;
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
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/listRoom")
    public List<Room> findAllRoom(){
        return StreamSupport.stream(roomRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/room/{id}")
    public Optional<Room> findById(@PathVariable("id")UUID id){
        return roomRepository.findById(id);
    }

}
