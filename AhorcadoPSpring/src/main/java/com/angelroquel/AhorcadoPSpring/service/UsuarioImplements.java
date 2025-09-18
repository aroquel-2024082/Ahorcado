package com.angelroquel.AhorcadoPSpring.service;

import com.angelroquel.AhorcadoPSpring.model.Usuario;
import com.angelroquel.AhorcadoPSpring.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImplements implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ValidacionUsuario validacionUsuario;

    public UsuarioImplements(UsuarioRepository usuarioRepository, ValidacionUsuario validacionUsuario) {
        this.usuarioRepository = usuarioRepository;
        this.validacionUsuario = validacionUsuario;
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
        String mensaje = validacionUsuario.validarUsuario(usuario, false); // false para "agregar"
        if (mensaje != null) {
            throw new DataIntegrityViolationException(mensaje);
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Usuario existinUsuario = usuarioRepository.findById(id).orElse(null);
        if (existinUsuario != null) {
            usuario.setId_Usuario(id);
            String mensaje = validacionUsuario.validarUsuario(usuario, true);
            if (mensaje != null) {
                throw new DataIntegrityViolationException(mensaje);
            }
            existinUsuario.setNombreUsuario(usuario.getNombreUsuario());
            existinUsuario.setContrasenia(usuario.getContrasenia());
            return usuarioRepository.save(existinUsuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}