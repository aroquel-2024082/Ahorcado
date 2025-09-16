package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Palabra;
import java.util.List;

public interface PalabraService {
    List<Palabra> getAllPalabras();
    Palabra getPalabraById(Integer id);
    Palabra savePalabra(Palabra palabra);
    Palabra updatePalabra(Integer id, Palabra palabra);
    void deletePalabra(Integer id);
}