package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Palabra;
import com.angelroquel.AhorcadoPSpring.repository.PalabraRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalabraImplements implements PalabraService {

    private final PalabraRepository palabraRepository;
    private final ValadacionPalabra valadacionPalabra;

    public PalabraImplements(PalabraRepository palabraRepository, ValadacionPalabra valadacionPalabra) {
        this.palabraRepository = palabraRepository;
        this.valadacionPalabra = valadacionPalabra;
    }

    @Override
    public List<Palabra> getAllPalabras() {
        return palabraRepository.findAll();
    }

    @Override
    public Palabra getPalabraById(Integer id) {
        Optional<Palabra> optionalPalabra = palabraRepository.findById(id);
        return optionalPalabra.orElse(null);
    }

    @Override
    public Palabra savePalabra(Palabra palabra) {
        String mensaje = valadacionPalabra.validarPalabra(palabra, false);
        if (mensaje != null) {
            throw new DataIntegrityViolationException(mensaje);
        }
        return palabraRepository.save(palabra);
    }

    @Override
    public Palabra updatePalabra(Integer id, Palabra palabra) {
        Palabra existinPalabra = palabraRepository.findById(id).orElse(null);
        if (existinPalabra != null) {
            palabra.setId_Palabra(id);
            String mensaje = valadacionPalabra.validarPalabra(palabra, true);
            if (mensaje != null) {
                throw new DataIntegrityViolationException(mensaje);
            }
            existinPalabra.setPalabra(palabra.getPalabra());
            existinPalabra.setPistaUno(palabra.getPistaUno());
            existinPalabra.setPistaDos(palabra.getPistaDos());
            existinPalabra.setPistaTres(palabra.getPistaTres());
            return palabraRepository.save(existinPalabra);
        }
        return null;
    }

    @Override
    public void deletePalabra(Integer id) {
        palabraRepository.deleteById(id);
    }
}