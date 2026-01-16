package com.dto;

import lombok.Data;

@Data
public class SimulationRequest {
    private GraphRequest graph;
    private FloodRequest flood;
}

