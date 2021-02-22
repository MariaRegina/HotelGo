package com.mrsdeus.hotelgo.hotelApi.dto;

import com.mrsdeus.hotelgo.hotelApi.entities.Room;
import org.modelmapper.ModelMapper;

public class RoomDto {
    Integer numero;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.numero = room.getNumero();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public static RoomDto entityToDto(Room room){
        if(room == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(room, RoomDto.class);
    }
}
