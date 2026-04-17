package org.example.security.services;

import org.example.security.DTOs.UsuarioRequestDTO;
import org.example.security.DTOs.UsuarioResponseDTO;
import org.example.security.entities.Usuario;
import org.example.security.entities.enums.Role;
import org.example.security.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setRole(Role.ROLE_USER);

        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuario.getNome(), usuario.getEmail());
    }
}
