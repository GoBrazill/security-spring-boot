package org.example.security.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.security.entities.enums.Role;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Role role;

}
