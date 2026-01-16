package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class NodeEntity {

    @Id
    private Integer id;

    private int x;
    private int y;

    @ManyToOne
    private GraphEntity graph;
}
