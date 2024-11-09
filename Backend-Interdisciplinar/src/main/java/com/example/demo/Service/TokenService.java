package com.example.demo.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.Model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private final String secretKey = "AKSJNDSA790KJBASB89HASHF";

    public String tokenGeneration(Usuario usuario) {
        return JWT.create()
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String getSubject(String token) {
        token = token.replace("Bearer ", "");
        return JWT.require(Algorithm.HMAC256(secretKey))
                .build().verify(token).getSubject();
    }

    public String getClaimId(String token) {
        token = token.replace("Bearer ", "");
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token);
        String id = String.valueOf(jwt.getClaims().get("id"));
        return id.substring(1, id.length() - 1);
    }
}