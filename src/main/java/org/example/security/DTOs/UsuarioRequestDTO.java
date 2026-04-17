package org.example.security.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    private String nome;
    private String email;
    @NotBlank
    @Size(min = 8, max = 20)
    private String senha;


}
