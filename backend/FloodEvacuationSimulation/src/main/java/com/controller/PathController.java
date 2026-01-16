package com.controller;

import com.core.Graph;
import com.dto.*;
import com.service.FloodService;
import com.service.GraphService;
import com.service.PathService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/path")
@RequiredArgsConstructor
public class PathController {

    private final GraphService graphService;
    private final FloodService floodService;
    private final PathService pathService;

    @PostMapping("/safe")
    public PathResponse safePath(
            @RequestBody PathSimulationRequest request
    ) {
        Graph graph = graphService.buildGraph(request.getGraph());

        FloodResponse floodResponse =
                floodService.simulate(graph, request.getFlood());

        return pathService.findPath(
                graph,
                floodResponse.getFloodTimes(),
                request.getPath()
        );
    }
}
