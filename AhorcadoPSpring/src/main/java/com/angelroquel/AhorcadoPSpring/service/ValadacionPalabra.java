package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Palabra;
import com.angelroquel.AhorcadoPSpring.repository.PalabraRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValadacionPalabra {
    private final PalabraRepository palabraRepository;

    public ValadacionPalabra(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }

    public String validarPalabra(Palabra palabra, boolean isUpdate) {

        //Verifica si la palabra ya existe en la base de datos
        Optional<Palabra> existingPalabraByPalabra = palabraRepository.findByPalabra(palabra.getPalabra());
        if (existingPalabraByPalabra.isPresent() && (!isUpdate || !existingPalabraByPalabra.get().getId_Palabra().equals(palabra.getId_Palabra()))) {
            return "La palabra '" + palabra.getPalabra() + "' ya existe en la base de datos.";
        }

        //Verifica si la pista 1 ya existe en la base de datos
        Optional<Palabra> existingPalabraByPistaUno = palabraRepository.findByPistaUno(palabra.getPistaUno());
        if (existingPalabraByPistaUno.isPresent() && (!isUpdate || !existingPalabraByPistaUno.get().getId_Palabra().equals(palabra.getId_Palabra()))) {
            return "La pista 1 '" + palabra.getPistaUno() + "' ya existe en la base de datos.";
        }

        //Verifica si la pista 2 ya existe en la base de datos
        Optional<Palabra> existingPalabraByPistaDos = palabraRepository.findByPistaDos(palabra.getPistaDos());
        if (existingPalabraByPistaDos.isPresent() && (!isUpdate || !existingPalabraByPistaDos.get().getId_Palabra().equals(palabra.getId_Palabra()))) {
            return "La pista 2 '" + palabra.getPistaDos() + "' ya existe en la base de datos.";
        }

        //Verifica si la pista 3 ya existe en la base de datos
        Optional<Palabra> existingPalabraByPistaTres = palabraRepository.findByPistaTres(palabra.getPistaTres());
        if (existingPalabraByPistaTres.isPresent() && (!isUpdate || !existingPalabraByPistaTres.get().getId_Palabra().equals(palabra.getId_Palabra()))) {
            return "La pista 3 '" + palabra.getPistaTres() + "' ya existe en la base de datos.";
        }
        return null;
    }
}
