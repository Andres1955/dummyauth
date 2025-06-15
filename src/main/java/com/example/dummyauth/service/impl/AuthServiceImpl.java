package com.example.dummyauth.service.impl;

import com.example.dummyauth.client.DummyJsonClient;
import com.example.dummyauth.dto.external.DummyJsonAuthRequest;
import com.example.dummyauth.dto.external.DummyJsonAuthResponse;
import com.example.dummyauth.dto.external.DummyJsonUserResponse;
import com.example.dummyauth.dto.external.DummyJsonUsersResponse;
import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.dto.response.UserResponse;
import com.example.dummyauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public UserResponse getCurrentUser(String token) {
        DummyJsonUserResponse response = dummyJsonClient.getCurrentUser(token);
        return new UserResponse(
                (long) response.id(),
                response.username(),
                response.email(),
                response.firstName(),
                response.lastName(),
                response.gender(),
                response.image()
        );
    }

    @Override
    public List<UserResponse> getTestUsers() {
        DummyJsonUsersResponse response = dummyJsonClient.getUsers();
        return response.users().stream()
                .map(user -> new UserResponse(
                        (long) user.id(),
                        user.username(),
                        user.email(),
                        user.firstName(),
                        user.lastName(),
                        user.gender(),
                        user.image()))
                .collect(Collectors.toList());
    }
}