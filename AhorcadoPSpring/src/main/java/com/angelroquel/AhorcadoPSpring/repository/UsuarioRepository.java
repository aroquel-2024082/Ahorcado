package com.angelroquel.AhorcadoPSpring.repository;

import com.angelroquel.AhorcadoPSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Spring Data JPA se encarga de las implementaciones por ti.
}