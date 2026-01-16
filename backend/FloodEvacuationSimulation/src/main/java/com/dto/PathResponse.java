package com.dto;


import java.util.List;

public class PathResponse {

    private List<Integer> path;
    private int time;

    public PathResponse(List<Integer> path, int time) {
        this.path = path;
        this.time = time;
    }

    public List<Integer> getPath() {
        return path;
    }

    public int getTime() {
        return time;
    }
}
