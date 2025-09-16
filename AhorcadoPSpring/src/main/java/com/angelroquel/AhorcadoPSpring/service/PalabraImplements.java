package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Palabra;
import com.angelroquel.AhorcadoPSpring.repository.PalabraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalabraImplements implements PalabraService {

    private final PalabraRepository palabraRepository;

    public PalabraImplements(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
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
        return palabraRepository.save(palabra);
    }

    @Override
    public Palabra updatePalabra(Integer id, Palabra palabra) {
        Palabra existingPalabra = palabraRepository.findById(id).orElse(null);
        if (existingPalabra != null) {
            existingPalabra.setPalabra(palabra.getPalabra());
            existingPalabra.setPistaUno(palabra.getPistaUno());
            existingPalabra.setPistaDos(palabra.getPistaDos());
            return palabraRepository.save(existingPalabra);
        }
        return null;
    }

    @Override
    public void deletePalabra(Integer id) {
        palabraRepository.deleteById(id);
    }
}