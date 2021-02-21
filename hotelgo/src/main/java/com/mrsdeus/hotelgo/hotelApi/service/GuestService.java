package com.mrsdeus.hotelgo.hotelApi.service;

import com.mrsdeus.hotelgo.hotelApi.entities.Guest;
import com.mrsdeus.hotelgo.hotelApi.repositories.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuestService implements IGuestService{

    private GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Optional<Guest> findById(UUID id) {
        return guestRepository.findById(id);
    }

    @Override
    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public void deleteById(UUID id) {
        guestRepository.deleteById(id);
    }

    public Guest findByPersonName(String nome){
        return guestRepository.findByPersonName(nome);
    }
}
