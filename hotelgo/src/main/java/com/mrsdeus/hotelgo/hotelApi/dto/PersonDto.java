package com.mrsdeus.hotelgo.hotelApi.dto;

import com.mrsdeus.hotelgo.hotelApi.entities.Person;
import org.modelmapper.ModelMapper;

import java.sql.Date;

public class PersonDto {

    private String name;

    private String cpf;

    private Date dateBirth;

    public PersonDto(){}

    public PersonDto(Person person){
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.dateBirth = person.getDateBirth();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public static PersonDto entityToDto(Person person) {
        if(person == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(person, PersonDto.class);
    }
}
