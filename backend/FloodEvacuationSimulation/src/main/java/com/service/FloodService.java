package com.service;

import com.core.Graph;
import com.core.flood.FloodSimulator;
import com.dto.FloodRequest;
import com.dto.FloodResponse;

import org.springframework.stereotype.Service;

@Service
public class FloodService {

    public FloodResponse simulate(Graph graph, FloodRequest req) {
        FloodSimulator sim = new FloodSimulator(graph);
        return new FloodResponse(
                sim.simulate(req.getSources(), req.getSpeed())
        );
    }
}
