package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class EdgeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private int fromNode;
    private int toNode;
    private int weight;

    @ManyToOne
    private GraphEntity graph;
}
