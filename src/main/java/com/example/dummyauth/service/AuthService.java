package com.example.dummyauth.service;

import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.dto.response.UserResponse;

import java.util.List;

public interface AuthService {
    AuthResponse authenticate(LoginRequest loginRequest);
    UserResponse getCurrentUser(String token);
    List<UserResponse> getTestUsers();
}