package com.tfalc.cepapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "City")
public class CityCep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cityCep;
    private String cityName;
    private String nomeLoja;
    private Long faixaInicial;
    private Long faixaFinal;

    public CityCep() {

    }

    public CityCep(Long id, Long cityCep, String cityName, String nomeLoja, Long faixaInicial, Long faixaFinal) {
        this.id = id;
        this.cityCep = cityCep;
        this.cityName = cityName;
        this.nomeLoja = nomeLoja;
        this.faixaInicial = faixaInicial;
        this.faixaFinal = faixaFinal;
    }
}
