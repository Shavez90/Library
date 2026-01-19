package org.spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.spring.library.dto.LoginRequest;
import org.spring.library.dto.LoginResponse;
import org.spring.library.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        String token = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(
                new LoginResponse(token, request.getEmail())
        );
    }
}
