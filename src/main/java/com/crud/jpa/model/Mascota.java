package com.crud.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_mascota;
    private String nombre;
    private String especies;
    private String raza;
    private String color;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String especies, String raza, String color) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especies = especies;
        this.raza = raza;
        this.color = color;
    }
}
