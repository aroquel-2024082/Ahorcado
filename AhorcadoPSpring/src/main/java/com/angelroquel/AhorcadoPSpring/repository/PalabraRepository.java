package com.angelroquel.AhorcadoPSpring.repository;

import com.angelroquel.AhorcadoPSpring.model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra, Integer> {
    Optional<Palabra> findByPalabra(String palabra);
    Optional<Palabra> findByPistaUno(String pistaUno);
    Optional<Palabra> findByPistaDos(String pistaDos);
    Optional<Palabra> findByPistaTres(String pistaTres);
}