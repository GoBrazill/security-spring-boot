package org.example.security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET = "thedadisawesomethereisnowayormaybethereisaway";

    public String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }
}
