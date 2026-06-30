package io.github.aprovadespesas.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration}")
    private Long expiration;

    public String generateToken(UserDetails u) {
        return Jwts.builder()
                .subject(u.getUsername())
                .issuedAt(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigingKey()).compact();
    }

    public boolean isTokenValid(String token, UserDetails u) {
        return extractionUserName(token).equals(u.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return extractClain(token, Claims::getExpiration).before(new Date());
    }

    public String extractionUserName(String token) {
        return extractClain(token, Claims::getSubject);
    }

    public <T> T extractClain(String token, Function<Claims, T> resolver){
        return resolver.apply(Jwts.parser()
                .verifyWith(getSigingKey())
                .build()
                .parseSignedClaims(token).getPayload());
    }
    private SecretKey getSigingKey() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secretKey)
        );
    }
}
