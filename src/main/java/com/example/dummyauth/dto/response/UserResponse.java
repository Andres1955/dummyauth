package com.example.dummyauth.dto.response;

public record UserResponse(
        Long id,
        String username,
        String email,
        String firstName,
        String lastName,
        String gender,
        String image
) {}