package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Usuario;
import com.angelroquel.AhorcadoPSpring.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidacionUsuario {

    private final UsuarioRepository usuarioRepository;

    public ValidacionUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String validarUsuario(Usuario usuario, boolean isUpdate) {
        Optional<Usuario> existingUsuario = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
        if (existingUsuario.isPresent()) {
            if (isUpdate && existingUsuario.get().getId_Usuario().equals(usuario.getId_Usuario())) {
                return null;
            }
            return "El nombre de usuario '" + usuario.getNombreUsuario() + "' ya existe en la base de datos.";
        }
        return null;
    }
}