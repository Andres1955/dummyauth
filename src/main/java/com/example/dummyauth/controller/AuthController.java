package com.example.dummyauth.controller;

import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.dto.response.UserResponse;
import com.example.dummyauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.authenticate(loginRequest);
    }

    @GetMapping("/me")
    public UserResponse getCurrentUser(@RequestHeader("Authorization") String token) {
        return authService.getCurrentUser(token);
    }

    @GetMapping("/test-users")
    public List<UserResponse> getTestUsers() {
        return authService.getTestUsers();
    }
}