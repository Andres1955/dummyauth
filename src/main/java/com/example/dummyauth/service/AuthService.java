package com.example.dummyauth.service;

import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(LoginRequest loginRequest);
}