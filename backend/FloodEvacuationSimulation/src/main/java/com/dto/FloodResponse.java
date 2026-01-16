package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class FloodResponse {
    private Map<Integer, Integer> floodTimes;
}
