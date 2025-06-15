package com.example.dummyauth.client;

import com.example.dummyauth.dto.external.DummyJsonAuthRequest;
import com.example.dummyauth.dto.external.DummyJsonAuthResponse;
import com.example.dummyauth.dto.external.DummyJsonUserResponse;
import com.example.dummyauth.dto.external.DummyJsonUsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dummyJsonClient", url = "https://dummyjson.com")
public interface DummyJsonClient {

    @PostMapping(value = "/auth/login", consumes = "application/json")
    DummyJsonAuthResponse authenticate(@RequestBody DummyJsonAuthRequest request);

    @GetMapping(value = "/auth/me")
    DummyJsonUserResponse getCurrentUser(@RequestHeader("Authorization") String token);

    @GetMapping(value = "/users")
    DummyJsonUsersResponse getUsers();
}