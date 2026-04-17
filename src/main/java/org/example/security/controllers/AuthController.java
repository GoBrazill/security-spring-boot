package org.example.security.controllers;

import org.example.security.DTOs.LoginDTO;
import org.example.security.services.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private  final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("login")
    public String login(@RequestBody LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getSenha()
                )
        );
        return jwtService.gerarToken(loginDTO.getEmail());
    }
}
