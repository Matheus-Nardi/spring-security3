package com.mafn.infra.security.webtoken;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtService {

    private static final String SECRET = "9A8CCECD0BE05ECD71878809CB6AE3A363CAE474BBB2251E4A4C741B332E8EFF";
    private static final Long VALIDITY = TimeUnit.MINUTES.toMillis(30);
    public String generateToken(UserDetails userDetails){ 
        return Jwts.builder()
            .subject(userDetails.getUsername())
            .issuedAt(Date.from(Instant.now()))
            .expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
            .signWith(generatedSecretKey())
            .compact();
    }
    

    private SecretKey generatedSecretKey(){
        byte[] decodeKey = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(decodeKey);
    }
}
