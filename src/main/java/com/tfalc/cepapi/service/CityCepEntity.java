package com.tfalc.cepapi.service;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "City")
public class CityCepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Cep;

    public void FindByCep(final Long id, final String Cep){
        this.id = id;
        this.Cep = Cep;
    }
}
