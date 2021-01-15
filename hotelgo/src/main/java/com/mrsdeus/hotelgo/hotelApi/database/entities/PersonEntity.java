package com.mrsdeus.hotelgo.hotelApi.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@Entity
public class PersonEntity {
    @Id
    private UUID id;


    private String name;

    private Date dateBirth;

    private String cpf;
}
