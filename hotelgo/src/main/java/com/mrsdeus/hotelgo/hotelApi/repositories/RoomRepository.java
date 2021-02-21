package com.mrsdeus.hotelgo.hotelApi.repositories;

import com.mrsdeus.hotelgo.hotelApi.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository <Room, UUID> {
}
