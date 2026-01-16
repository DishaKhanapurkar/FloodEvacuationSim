package com.controller;

import com.dto.GraphRequest;
import com.service.GraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/graph")
@RequiredArgsConstructor
public class GraphController {

    private final GraphService graphService;

    @PostMapping
    public ResponseEntity<Void> upload(@RequestBody GraphRequest req) {
        graphService.buildGraph(req);
        return ResponseEntity.ok().build();
    }
}
