package com.example.demo.Dto;

import java.util.List;

public record PlanPageResponse(
    List<PlanResponse> items,
    int page,
    int pagesize,
    Long total

    ){}
