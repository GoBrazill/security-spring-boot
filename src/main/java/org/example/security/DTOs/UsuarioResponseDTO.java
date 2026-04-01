package org.example.security.DTOs;

import lombok.Data;
import org.example.security.entities.enums.Role;

@Data
public class UsuarioResponseDTO {

    private String nome;
    private String email;

    public UsuarioResponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
