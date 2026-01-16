package com.core.pathfinding;


import com.core.Edge;
import com.core.Graph;


import java.util.*;

/**
 * Finds a safe evacuation path by ensuring arrival time
 * at each node is earlier than flood arrival time.
 */
public class SafePathFinder {

    private final Graph graph;
    private final Map<Integer, Integer> floodTime;
    private int totalTime = -1;

    public SafePathFinder(Graph graph, Map<Integer, Integer> floodTime) {
        this.graph = graph;
        this.floodTime = floodTime;
    }

    /**
     * Finds a safe path from start to destination.
     *
     * @return list of node ids representing the path,
     *         or empty list if no safe path exists.
     */
    public List<Integer> findPath(int start, int destination) {

        Map<Integer, Integer> bestTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        PriorityQueue<State> pq = new PriorityQueue<>();

        for (int node : graph.getAllNodeIds()) {
            bestTime.put(node, Integer.MAX_VALUE);
        }

        // Cannot start if starting node is already flooded
        if (floodTime.getOrDefault(start, Integer.MAX_VALUE) <= 0) {
            return Collections.emptyList();
        }

        bestTime.put(start, 0);
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.time > bestTime.get(current.node)) continue;

            if (current.node == destination) {
                totalTime = current.time;
                return buildPath(parent, destination);
            }

            for (Edge edge : graph.getEdgesFrom(current.node)) {
                int nextNode = edge.getTo();
                int arrivalTime = current.time + edge.getWeight();

                int floodArrival = floodTime.getOrDefault(nextNode, Integer.MAX_VALUE);

                if (arrivalTime >= floodArrival) continue;

                if (arrivalTime < bestTime.get(nextNode)) {
                    bestTime.put(nextNode, arrivalTime);
                    parent.put(nextNode, current.node);
                    pq.offer(new State(nextNode, arrivalTime));
                }
            }
        }

        return Collections.emptyList();
    }

    public int getTotalTime() {
        return totalTime;
    }

    private List<Integer> buildPath(Map<Integer, Integer> parent, int dest) {
        LinkedList<Integer> path = new LinkedList<>();
        int current = dest;

        while (parent.containsKey(current)) {
            path.addFirst(current);
            current = parent.get(current);
        }

        path.addFirst(current);
        return path;
    }

    // Internal state
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
