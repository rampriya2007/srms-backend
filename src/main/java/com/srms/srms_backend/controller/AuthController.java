package com.srms.srms_backend.controller;

import com.srms.srms_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        // Hardcoded admin for now — Day 8 we move this to database
        if ("admin@srms.com".equals(email) && "admin123".equals(password)) {
            String token = jwtUtil.generateToken(email);
            return ResponseEntity.ok(Map.of("token", token, "email", email));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}