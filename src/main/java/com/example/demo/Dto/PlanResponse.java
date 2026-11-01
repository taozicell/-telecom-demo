package com.example.demo.Dto;

public record PlanResponse(
        Long id,
        String name,
        Integer monthlyFeeFen,
        Integer dataGb
) {
}