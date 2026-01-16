package com.service;

import com.core.Graph;
import com.core.pathfinding.SafePathFinder;
import com.dto.PathRequest;
import com.dto.PathResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PathService {

    public PathResponse findPath(
            Graph graph,
            Map<Integer, Integer> floodTimes,
            PathRequest req
    ) {
        SafePathFinder finder =
                new SafePathFinder(graph, floodTimes);

        List<Integer> path =
                finder.findPath(req.getStart(), req.getEnd());

        return new PathResponse(path, finder.getTotalTime());
    }
}
