package com.java.todomangement.Todo_Mangement.securitty;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private String jwtExpirationDate;
    public String genrateToken(Authentication authentication){
        String username = authentication.getName();
        Date currnetDate = new Date();
        Date expireDate = new Date(currnetDate.getTime() + jwtExpirationDate);
        String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expireDate).signWith(keys()).compact();
        return token;
    }

    private Key keys(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtecret)
        );
    }
    //get username from jwt token
    public String getUserName(String token){
        Claims claims = Jwts.parser().setSigningKey(keys()).build().parseClaimsJwt(token).getBody();
        String username = claims.getSubject();
        return username;
    }
    public boolean validateToken(String token){
        Jwts.parser().setSigningKey(keys()).build().parse(token);
        return true;
    }
}
