package com.core.flood;



import com.core.Edge;
import com.core.Graph;


import java.util.*;

/**
 * Simulates flood propagation over a graph and computes
 * the earliest time each node gets flooded.
 */
public class FloodSimulator {

    private final Graph graph;

    public FloodSimulator(Graph graph) {
        this.graph = graph;
    }

    /**
     * @param sources list of starting flood nodes
     * @param speed   flood speed multiplier (>=1)
     * @return map of nodeId -> flood arrival time
     */
    public Map<Integer, Integer> simulate(List<Integer> sources, int speed) {

        Map<Integer, Integer> floodTime = new HashMap<>();
        PriorityQueue<State> pq = new PriorityQueue<>();

        // Initialize all nodes as unreachable by flood
        for (int nodeId : graph.getAllNodeIds()) {
            floodTime.put(nodeId, Integer.MAX_VALUE);
        }

        // Multi-source initialization
        for (int src : sources) {
            floodTime.put(src, 0);
            pq.offer(new State(src, 0));
        }

        // Dijkstra-style expansion
        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.time > floodTime.get(current.node)) continue;

            for (Edge edge : graph.getEdgesFrom(current.node)) {
                int nextNode = edge.getTo();
                int travelTime = edge.getWeight() / speed;
                if (travelTime <= 0) travelTime = 1;

                int arrivalTime = current.time + travelTime;

                if (arrivalTime < floodTime.get(nextNode)) {
                    floodTime.put(nextNode, arrivalTime);
                    pq.offer(new State(nextNode, arrivalTime));
                }
            }
        }

        return floodTime;
    }

    // Internal state class
    private static class State implements Comparable<State> {
        int node;
        int time;

        State(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(State other) {
            return Integer.compare(this.time, other.time);
        }
    }
}
