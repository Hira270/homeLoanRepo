package com.homeloan.homeloan.controller;

import com.homeloan.homeloan.domain.LoginRequest;
import com.homeloan.homeloan.domain.LoginResponse;
import com.homeloan.homeloan.entity.User;
import com.homeloan.homeloan.repository.UserRepository;
import com.homeloan.homeloan.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Slf4j
public class LoginController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public LoginController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest == null) {
            throw new IllegalArgumentException("please give valid credential");
        }
        log.debug("Login attempt for username: {}", loginRequest.getUsername());
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());

        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            log.debug("User found: {}", user.get().getUsername());
            String token = jwtUtil.generateToken(user.get().getUsername(), user.get().getRole());
            log.debug("JWT generated successfully for user: {}", user.get().getUsername());
            return ResponseEntity.ok(new LoginResponse(token));
        } else {
            log.debug("User not found for username: {}", loginRequest.getUsername());
            throw new IllegalArgumentException("please give valid credential");
        }
    }



    /*@PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody LoginRequest loginRequest, @RequestHeader("Authorization") String token) {
        //String authHeader = request.getHeader("Authorization");

        if (StringUtils.isNotEmpty(token)) {
            //String token = authHeader.substring(7);
            jwtUtil.invalidateToken(token);  // Implement token invalidation logic
            log.debug("User logged out successfully. Token invalidated.");
            return ResponseEntity.ok("Logged out successfully");
        } else {
            log.debug("No valid token found for logout.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No active session found.");
        }
    }*/
}