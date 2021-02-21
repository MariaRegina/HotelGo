package com.mrsdeus.hotelgo.hotelApi.service;

import com.mrsdeus.hotelgo.hotelApi.entities.Room;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRoomService {
    List<Room> findAll();

    Optional<Room> findById(UUID id);

    void save(Room room);

    void deleteById(UUID id);
}
