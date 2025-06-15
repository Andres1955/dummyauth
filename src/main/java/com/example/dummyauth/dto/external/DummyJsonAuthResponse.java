package com.example.dummyauth.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DummyJsonAuthResponse(
        int id,
        String username,
        String email,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        String gender,
        String image,
        @JsonProperty("accessToken") String token
) {}