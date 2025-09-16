package com.angelroquel.AhorcadoPSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")

public class Usuario {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id_Usuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "contrasenia")
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(Integer id_Usuario, String nombreUsuario, String contrasenia) {
        this.id_Usuario = id_Usuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
