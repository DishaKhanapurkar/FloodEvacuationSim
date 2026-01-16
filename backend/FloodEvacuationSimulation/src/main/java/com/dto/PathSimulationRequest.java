package com.dto;


public class PathSimulationRequest {

    private GraphRequest graph;
    private FloodRequest flood;
    private PathRequest path;

    public PathSimulationRequest() {
    }

    public GraphRequest getGraph() {
        return graph;
    }

    public void setGraph(GraphRequest graph) {
        this.graph = graph;
    }

    public FloodRequest getFlood() {
        return flood;
    }

    public void setFlood(FloodRequest flood) {
        this.flood = flood;
    }

    public PathRequest getPath() {
        return path;
    }

    public void setPath(PathRequest path) {
        this.path = path;
    }
}
