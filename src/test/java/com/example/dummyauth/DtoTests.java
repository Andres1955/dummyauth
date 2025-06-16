package com.example.dummyauth;

import com.example.dummyauth.dto.external.DummyJsonAuthRequest;
import com.example.dummyauth.dto.external.DummyJsonAuthResponse;
import com.example.dummyauth.dto.external.DummyJsonUserResponse;
import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.dto.response.UserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtoTests {

    @Test
    void loginRequest_ShouldHoldValues() {
        LoginRequest request = new LoginRequest("user", "pass");
        assertEquals("user", request.username());
        assertEquals("pass", request.password());
    }

    @Test
    void authResponse_ShouldHoldValues() {
        AuthResponse response = new AuthResponse("token", "user");
        assertEquals("token", response.token());
        assertEquals("user", response.username());
    }

    @Test
    void userResponse_ShouldHoldValues() {
        UserResponse response = new UserResponse(
                1L, "user", "email@test.com", "First", "Last", "gender", "image");

        assertEquals(1L, response.id());
        assertEquals("user", response.username());
        assertEquals("First", response.firstName());
        assertEquals("Last", response.lastName());
    }

    @Test
    void dummyJsonAuthRequest_ShouldHoldValues() {
        DummyJsonAuthRequest request = new DummyJsonAuthRequest("user", "pass");
        assertEquals("user", request.username());
        assertEquals("pass", request.password());
    }

    @Test
    void dummyJsonAuthResponse_ShouldHoldValues() {
        DummyJsonAuthResponse response = new DummyJsonAuthResponse(
                1, "user", "email@test.com", "First", "Last", "gender", "image", "token");

        assertEquals(1, response.id());
        assertEquals("user", response.username());
        assertEquals("token", response.token());
    }

    @Test
    void dummyJsonUserResponse_ShouldHoldValues() {
        DummyJsonUserResponse response = new DummyJsonUserResponse(
                1, "user", "email@test.com", "First", "Last", "gender", "image");

        assertEquals(1, response.id());
        assertEquals("user", response.username());
        assertEquals("First", response.firstName());
    }
}