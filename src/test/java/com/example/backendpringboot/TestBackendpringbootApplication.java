package com.example.backendpringboot;

import org.springframework.boot.SpringApplication;

public class TestBackendpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.from(BackendpringbootApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
