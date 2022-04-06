package no.ntnu.calculator.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

@Configuration
public class JwtUtil {

    private static String key = "Detteerenmidlertidigogutryggnoekkelsommaaendres";

    /**
     * Generates access tokens that last a day
     * @param subject user to create token for
     * @return token
     */
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date()).setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8))).compact();
    }

    /**
     * Decodes an access token. Throws JwtException if there is an error
     * @param token token to decode
     * @return subject of token (the user)
     */
    public String decode(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }
}
