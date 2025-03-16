package com.homeloan.homeloan.config;

import com.homeloan.homeloan.enums.Role;
import com.homeloan.homeloan.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import static com.homeloan.homeloan.common.ConstantUtils.INVALID_TOKEN;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        log.info("doFilterInternal request{}", request);
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7).trim();
            log.debug("Extracted token: {}", token);
            try {
                String username = jwtUtil.extractUsername(token);
                Role role = jwtUtil.extractRole(token);
                log.debug("Extracted username: {}, role: {}", username, role);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    log.debug("Creating authentication token for user: {}", username);
                    UserDetails userDetails = new User(username, "",
                            List.of(new SimpleGrantedAuthority("ROLE_" + role.name())));

                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    log.debug("User {} authenticated successfully with role {}", username, role);
                }
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, INVALID_TOKEN);
                return;
            }
        } else {
            log.debug("No Authorization header found or doesn't start with 'Bearer '");
        }

        chain.doFilter(request, response);
        log.debug("JWT authentication completed, proceeding with request.");
    }
}