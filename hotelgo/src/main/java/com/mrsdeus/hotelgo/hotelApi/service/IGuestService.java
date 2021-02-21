package com.mrsdeus.hotelgo.hotelApi.service;

import com.mrsdeus.hotelgo.hotelApi.dto.GuestDto;
import com.mrsdeus.hotelgo.hotelApi.entities.Guest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGuestService {
    List<Guest> findAll();

    Optional<Guest> findById(UUID id);

    void save(Guest guest);

    void deleteById(UUID id);

    Guest findByPersonName(String nome);
}
