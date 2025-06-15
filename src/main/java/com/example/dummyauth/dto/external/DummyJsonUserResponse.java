package com.example.dummyauth.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DummyJsonUserResponse(
        int id,
        String username,
        String email,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        String gender,
        String image
) {}