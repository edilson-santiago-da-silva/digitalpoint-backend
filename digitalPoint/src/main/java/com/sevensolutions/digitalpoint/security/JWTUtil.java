package com.sevensolutions.digitalpoint.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String name){
        Algorithm algorithm = Algorithm.HMAC512(secret.getBytes());

        return JWT.create()
                .withSubject(name)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(algorithm);
    }

    public boolean validToken(String token) {
        try {
            DecodedJWT jwt = getDecodedJWT(token);
            String username = jwt.getSubject();
            Date expirationDate = jwt.getExpiresAt();
            Date now = new Date(System.currentTimeMillis());

            return username != null && expirationDate != null && now.before(expirationDate);
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        try {
            DecodedJWT jwt = getDecodedJWT(token);
            return jwt.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private DecodedJWT getDecodedJWT(String token) {
        return JWT.require(Algorithm.HMAC512(secret.getBytes()))
                .build()
                .verify(token);
    }
}
