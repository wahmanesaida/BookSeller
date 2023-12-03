package com.books.bookseller.Config;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String Secret_key="6VFjs7JeJSu//1mXBheB0V6HODTTmjTzOJkowkncXBcD7ZdE50dlS5odVWXS2vtd90DJdAyhmajDETs3kpI5u7DwnT98tojgqMn5nlE4EmfAKWxZlioCo0dIda9XI9sjMaqYJ0BysHmx+AIyKwzzYe37uebUTkGU8UwDom1v4nCIjswvKk3zGr+LB+gs4opnrzEadwrPLz7JzmWqlEf3Qz132mH33i5nkfj0+G4EVkxtdRIonytY4dH8x83AVL17BfIeF1XSY9KNOP9JDNadoWEjf5zDjNcSg1CP6Vsx1bzh5P2Lj1tmyLA2Ps4c4e/kZcv+wyFoXjfA8iQYqlao2pp1xzDKtThF+PZMeoHitEc=";

    public String extractUsername(String jwt) {
        return null;
    }

    //methode to extract all claims

    private Claims extractAllClaims(String token){
        return Jwts
        .parserBuilder().setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
        
    }

    private Key getSignInKey() {
       byte[] keyBytes= Decoders.BASE64.decode(Secret_key);
       return Keys.hmacShaKeyFor(keyBytes);
    }
    

}
