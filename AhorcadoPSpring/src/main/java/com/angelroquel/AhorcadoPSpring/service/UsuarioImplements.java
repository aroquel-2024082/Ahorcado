package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Usuario;
import com.angelroquel.AhorcadoPSpring.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImplements implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioImplements(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
            existingUsuario.setContrasenia(usuario.getContrasenia());
            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}