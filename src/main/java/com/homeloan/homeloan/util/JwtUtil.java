package com.homeloan.homeloan.util;

import com.homeloan.homeloan.entity.User;
import com.homeloan.homeloan.enums.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class JwtUtil {
    private static final String SECRET_KEY = "Kjhd83jsdf82hsjdFhQ7hsfjshw9dhsfj28sfjsdfh3Fj=";

    private final Set<String> invalidatedTokens = ConcurrentHashMap.newKeySet();// 32-byte key (for HS256)

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username, Role role) {
        log.info("generateToken username{} role{}", username, role);
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role.name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())  // Ensure same signing key as generation
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            log.error("Error parsing token: {}", e.getMessage());
            return null;
        }
    }

    public Role extractRole(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())  // Ensure consistent key
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Retrieve the 'role' claim safely
            String role = claims.get("role", String.class);
            log.info("Extracted role: {}", role);

            // Convert String to Enum
            return Role.valueOf(role);
        } catch (JwtException e) {
            log.error("Error extracting role from token: {}", e.getMessage());
            return null;
        }
    }

    public boolean isTokenValid(String token) {
        if (invalidatedTokens.contains(token)) {
            log.debug("Token is invalid as it has been logged out.");
            return false;
        }
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.debug("Token expired: {}", e.getMessage());
        } catch (MalformedJwtException | SignatureException e) {
            log.debug("Invalid token: {}", e.getMessage());
        }
        return false;
    }

    public void invalidateToken(String token) {
        invalidatedTokens.add(token);
        log.debug("Token invalidated successfully.");
    }

    public boolean validateToken(String token, User user) {
        final String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenValid(token));
    }
}
