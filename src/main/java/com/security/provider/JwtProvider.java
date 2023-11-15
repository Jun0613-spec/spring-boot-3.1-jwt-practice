package com.security.provider;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtProvider {
    
    @Value("${jwt.secret}")
    private String secret;

    public String create(String email) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(expiredDate)
        .signWith(key)
        .compact();

        return jwt;
    }


    public String validate(String jwt) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        Claims claims = null;

        try{
            claims = Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(jwt).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }
    
}
