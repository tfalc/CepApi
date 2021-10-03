package com.tfalc.cepapi.model;

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
    private String CityName

    public void FindByCep(final Long id, final String Cep, final String CityName) {
        this.id = id;
        this.Cep = Cep;
        this.CityName = CityName;
    }
}
