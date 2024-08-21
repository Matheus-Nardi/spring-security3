package com.mafn.spring_security;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JwtSecretMakerTest {

    @Test
    public void generatedSecretKey() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String encodeKey = DatatypeConverter.printHexBinary(key.getEncoded());
        log.info("KEY = [{}]" , encodeKey);
    }
}
