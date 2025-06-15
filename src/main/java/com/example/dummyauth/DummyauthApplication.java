package com.example.dummyauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.dummyauth.client")
public class DummyauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyauthApplication.class, args);
	}
}
