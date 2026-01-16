package com.core;

/**
 * Represents a city node (intersection / location)
 */
public class Node {

    private final int id;
    private final int x;
    private final int y;

    public Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
