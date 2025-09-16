package com.angelroquel.AhorcadoPSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Palabra")

public class Palabra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Palabra;

    @Column(name = "palabra")
    private String palabra;

    @Column(name = "pista1")
    private String pistaUno;

    @Column(name = "pista2")
    private String pistaDos;

    public Palabra() {
    }

    public Palabra(Integer id_Palabra, String palabra, String pistaUno, String pistaDos) {
        this.id_Palabra = id_Palabra;
        this.palabra = palabra;
        this.pistaUno = pistaUno;
        this.pistaDos = pistaDos;
    }

    public Integer getId_Palabra() {
        return id_Palabra;
    }

    public void setId_Palabra(Integer id_Palabra) {
        this.id_Palabra = id_Palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPistaUno() {
        return pistaUno;
    }

    public void setPistaUno(String pistaUno) {
        this.pistaUno = pistaUno;
    }

    public String getPistaDos() {
        return pistaDos;
    }

    public void setPistaDos(String pistaDos) {
        this.pistaDos = pistaDos;
    }
}

