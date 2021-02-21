package com.mrsdeus.hotelgo.hotelApi.database;

import com.mrsdeus.hotelgo.hotelApi.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository <Guest, UUID> {
}
