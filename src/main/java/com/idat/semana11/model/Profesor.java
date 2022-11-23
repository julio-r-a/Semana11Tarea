package com.idat.semana11.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesor;
    private String nombre;
    private String apellido;
    private Integer edad;
}
