package com.example.dummyauth;

import com.example.dummyauth.controller.AuthController;
import com.example.dummyauth.dto.request.LoginRequest;
import com.example.dummyauth.dto.response.AuthResponse;
import com.example.dummyauth.dto.response.UserResponse;
import com.example.dummyauth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @Test
    void login_ShouldReturnAuthResponse() {
        // Arrange
        LoginRequest request = new LoginRequest("testuser", "testpass");
        AuthResponse mockResponse = new AuthResponse("token123", "testuser");

        when(authService.authenticate(any(LoginRequest.class))).thenReturn(mockResponse);

        // Act
        AuthResponse response = authController.login(request);

        // Assert
        assertNotNull(response);
        assertEquals("token123", response.token());
        assertEquals("testuser", response.username());
    }

    @Test
    void getCurrentUser_ShouldReturnUserResponse() {
        // Arrange
        String token = "Bearer token123";
        UserResponse mockResponse = new UserResponse(
                1L, "testuser", "test@example.com", "Test", "User", "male", "image.jpg"
        );

        when(authService.getCurrentUser(any(String.class))).thenReturn(mockResponse);

        // Act
        UserResponse response = authController.getCurrentUser(token);

        // Assert
        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals("testuser", response.username());
    }

    @Test
    void getTestUsers_ShouldReturnListOfUsers() {
        // Arrange
        UserResponse user1 = new UserResponse(
                1L, "user1", "user1@test.com", "User", "One", "male", "image1.jpg");
        UserResponse user2 = new UserResponse(
                2L, "user2", "user2@test.com", "User", "Two", "female", "image2.jpg");

        when(authService.getTestUsers()).thenReturn(List.of(user1, user2));

        // Act
        List<UserResponse> users = authController.getTestUsers();

        // Assert
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).username());
        assertEquals("user2", users.get(1).username());
    }
}