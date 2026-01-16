package com.core;


import java.util.*;

public class Graph {

    // adjacency list: node -> outgoing edges
    private final Map<Integer, List<Edge>> adjList = new HashMap<>();

    public void addNode(Node node) {
        adjList.putIfAbsent(node.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(from, to, weight));
        adjList.get(to).add(new Edge(to, from, weight));
    }

    public List<Edge> getEdgesFrom(int nodeId) {
        return adjList.getOrDefault(nodeId, Collections.emptyList());
    }

    public Set<Integer> getAllNodeIds() {
        return adjList.keySet();
    }
}
