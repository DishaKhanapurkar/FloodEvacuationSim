package com.controller;

import com.dto.FloodRequest;
import com.dto.FloodResponse;
import com.dto.GraphRequest;
import com.dto.SimulationRequest;
import com.service.FloodService;
import com.service.GraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flood")
@RequiredArgsConstructor
public class FloodController {

    private final FloodService floodService;
    private final GraphService graphService;

    @PostMapping("/simulate")
    public FloodResponse simulate(
            @RequestBody SimulationRequest request
    ) {
        GraphRequest graph = request.getGraph();
        FloodRequest flood = request.getFlood();
        return floodService.simulate(
                graphService.buildGraph(graph), flood
        );
    }
}
