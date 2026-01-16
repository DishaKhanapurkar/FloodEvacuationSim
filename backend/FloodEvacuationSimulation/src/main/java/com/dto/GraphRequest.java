package com.dto;

import lombok.Data;

import java.util.List;

public class GraphRequest {

    private String name;
    private List<NodeDTO> nodes;
    private List<EdgeDTO> edges;

    public GraphRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeDTO> nodes) {
        this.nodes = nodes;
    }

    public List<EdgeDTO> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeDTO> edges) {
        this.edges = edges;
    }
}