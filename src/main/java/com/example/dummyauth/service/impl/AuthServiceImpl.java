package com.example.dummyauth.service.impl;

import com.example.dummyauth.client.DummyJsonClient;
import com.example.dummyauth.dto.external.DummyJsonAuthRequest;
import com.example.dummyauth.dto.external.DummyJsonAuthResponse;
import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final DummyJsonClient dummyJsonClient;

    @Override
    public AuthResponse authenticate(LoginRequest loginRequest) {
        DummyJsonAuthRequest authRequest = new DummyJsonAuthRequest(
                loginRequest.username(),
                loginRequest.password()
        );

        DummyJsonAuthResponse response = dummyJsonClient.authenticate(authRequest);

        return new AuthResponse(response.token(), response.username());
    }
}
