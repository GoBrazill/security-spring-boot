package org.example.security.controllers;

import org.example.security.DTOs.UsuarioRequestDTO;
import org.example.security.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.criarUsuario(dto));
    }

    @GetMapping("admin")
    public String admin() {
        return "Acesso admin";
    }
}
