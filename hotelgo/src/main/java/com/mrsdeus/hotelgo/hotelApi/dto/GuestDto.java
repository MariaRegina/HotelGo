package com.mrsdeus.hotelgo.hotelApi.dto;

import com.mrsdeus.hotelgo.hotelApi.entities.Guest;
import org.modelmapper.ModelMapper;

public class GuestDto {

    PersonDto personDto;

    RoomDto roomDto;

    public GuestDto(){
    }

    public GuestDto(Guest guest){
        this.personDto = new PersonDto(guest.getPerson());
        this.roomDto = new RoomDto(guest.getRoom());
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public RoomDto getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDto roomDto) {
        this.roomDto = roomDto;
    }

    public static GuestDto entityToDto(Guest guest) {
        if(guest == null) return null;

        ModelMapper modelMapper = new ModelMapper();
        GuestDto guestDto = modelMapper.map(guest, GuestDto.class);
        guestDto.setPersonDto(PersonDto.entityToDto(guest.getPerson()));
        guestDto.setRoomDto(RoomDto.entityToDto(guest.getRoom()));

        return guestDto;
    }

}
