package com.example.dummyauth.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DummyJsonAuthResponse(
        int id,
        String username,
        String email,
        String firstName,
        String lastName,
        String gender,
        String image,
        String token
) {
}
