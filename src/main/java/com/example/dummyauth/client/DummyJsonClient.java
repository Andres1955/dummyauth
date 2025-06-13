package com.example.dummyauth.client;

import com.example.dummyauth.dto.external.DummyJsonAuthRequest;
import com.example.dummyauth.dto.external.DummyJsonAuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dummyJsonClient", url = "https://dummyjson.com")
public interface DummyJsonClient {

    @PostMapping(value = "/auth/login", consumes = "application/json")
    DummyJsonAuthResponse authenticate(@RequestBody DummyJsonAuthRequest request);
}
