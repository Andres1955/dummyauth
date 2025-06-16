package com.example.dummyauth;

import com.example.dummyauth.client.DummyJsonClient;
import com.example.dummyauth.dto.external.DummyJsonAuthRequest;
import com.example.dummyauth.dto.external.DummyJsonAuthResponse;
import com.example.dummyauth.dto.external.DummyJsonUserResponse;
import com.example.dummyauth.dto.external.DummyJsonUsersResponse;
import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.dto.response.UserResponse;
import com.example.dummyauth.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private DummyJsonClient dummyJsonClient;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    void authenticate_ShouldReturnAuthResponse() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest("testuser", "testpass");
        DummyJsonAuthResponse mockResponse = new DummyJsonAuthResponse(
                1, "testuser", "test@example.com", "Test", "User", "male", "image.jpg", "token123"
        );

        when(dummyJsonClient.authenticate(any(DummyJsonAuthRequest.class))).thenReturn(mockResponse);

        // Act
        AuthResponse response = authService.authenticate(loginRequest);

        // Assert
        assertNotNull(response);
        assertEquals("token123", response.token());
        assertEquals("testuser", response.username());
    }

    @Test
    void getCurrentUser_ShouldReturnUserResponse() {
        // Arrange
        String token = "Bearer token123";
        DummyJsonUserResponse mockResponse = new DummyJsonUserResponse(
                1, "testuser", "test@example.com", "Test", "User", "male", "image.jpg"
        );

        when(dummyJsonClient.getCurrentUser(any(String.class))).thenReturn(mockResponse);

        // Act
        UserResponse response = authService.getCurrentUser(token);

        // Assert
        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals("testuser", response.username());
        assertEquals("Test", response.firstName());
        assertEquals("User", response.lastName());
    }

    @Test
    void getTestUsers_ShouldReturnListOfUsers() {
        // Arrange
        DummyJsonUserResponse user1 = new DummyJsonUserResponse(
                1, "user1", "user1@test.com", "User", "One", "male", "image1.jpg");
        DummyJsonUserResponse user2 = new DummyJsonUserResponse(
                2, "user2", "user2@test.com", "User", "Two", "female", "image2.jpg");

        DummyJsonUsersResponse mockResponse = new DummyJsonUsersResponse(
                List.of(user1, user2), 2, 0, 10
        );

        when(dummyJsonClient.getUsers()).thenReturn(mockResponse);

        // Act
        List<UserResponse> users = authService.getTestUsers();

        // Assert
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).username());
        assertEquals("user2", users.get(1).username());
    }
}