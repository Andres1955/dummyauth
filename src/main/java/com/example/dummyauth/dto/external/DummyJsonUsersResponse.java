package com.example.dummyauth.dto.external;

import java.util.List;

public record DummyJsonUsersResponse(
        List<DummyJsonUserResponse> users,
        int total,
        int skip,
        int limit
) {}