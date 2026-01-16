package com.dto;

import lombok.Data;

import java.util.List;

public class FloodRequest {

    private List<Integer> sources;
    private int speed;

    public FloodRequest() {}

    public List<Integer> getSources() {
        return sources;
    }

    public void setSources(List<Integer> sources) {
        this.sources = sources;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

