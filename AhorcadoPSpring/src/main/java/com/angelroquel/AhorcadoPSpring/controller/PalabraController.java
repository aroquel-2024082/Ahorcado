package com.angelroquel.AhorcadoPSpring.controller;

import com.angelroquel.AhorcadoPSpring.model.Palabra;
import com.angelroquel.AhorcadoPSpring.service.PalabraService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palabras")
public class PalabraController {

    private final PalabraService palabraService;

    public PalabraController(PalabraService palabraService) {
        this.palabraService = palabraService;
    }

    @GetMapping
    public List<Palabra> getAllPalabras() {
        return palabraService.getAllPalabras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Palabra> getPalabraById(@PathVariable Integer id) {
        Palabra palabra = palabraService.getPalabraById(id);
        if (palabra != null) {
            return new ResponseEntity<>(palabra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createPalabra(@RequestBody Palabra palabra) {
        try {
            Palabra createdPalabra = palabraService.savePalabra(palabra);
            return new ResponseEntity<>(createdPalabra, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePalabra(@PathVariable Integer id, @RequestBody Palabra palabra) {
        try {
            Palabra updatedPalabra = palabraService.updatePalabra(id, palabra);
            if (updatedPalabra != null) {
                return new ResponseEntity<>(updatedPalabra, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Palabra no encontrada para actualizar.", HttpStatus.NOT_FOUND);
            }
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePalabra(@PathVariable Integer id) {
        palabraService.deletePalabra(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}