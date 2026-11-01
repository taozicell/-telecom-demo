package com.example.demo.common;

public record ApiError(
        int status,
        String message
){}
