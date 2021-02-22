package com.mrsdeus.hotelgo.hotelApi.controller;

import com.mrsdeus.hotelgo.hotelApi.dto.RoomDto;
import com.mrsdeus.hotelgo.hotelApi.entities.Room;
import com.mrsdeus.hotelgo.hotelApi.service.IRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/room")
public class RoomController {

    private IRoomService service;

    public RoomController(IRoomService service) {
        this.service = service;
    }

    @GetMapping(value = "/listRoom")
    public List<RoomDto> findAllRoom(){
        return StreamSupport.stream(service.findAll().spliterator(), false).map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoomDto findById(@PathVariable("id")UUID id){
        return RoomDto.entityToDto(service.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public void addRoom(@RequestBody Room room){
        service.save(room);
    }
}
