package com.service;

import com.core.Graph;
import com.core.Node;
import com.entity.EdgeEntity;
import com.entity.GraphEntity;
import com.entity.NodeEntity;
import com.dto.EdgeDTO;
import com.dto.GraphRequest;
import com.dto.NodeDTO;
import com.repository.EdgeRepository;
import com.repository.GraphRepository;
import com.repository.NodeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GraphService {

    private final GraphRepository graphRepo;
    private final NodeRepository nodeRepo;
    private final EdgeRepository edgeRepo;

    public Graph buildGraph(GraphRequest req) {

        GraphEntity graphEntity = new GraphEntity();
        graphEntity.setName(req.getName());
        graphEntity = graphRepo.save(graphEntity);

        Graph graph = new Graph();

        for (NodeDTO n : req.getNodes()) {
            NodeEntity nodeEntity = new NodeEntity();
            nodeEntity.setId(n.getId());
            nodeEntity.setX(n.getX());
            nodeEntity.setY(n.getY());
            nodeEntity.setGraph(graphEntity);
            nodeRepo.save(nodeEntity);

            graph.addNode(new Node(n.getId(), n.getX(), n.getY()));
        }

        for (EdgeDTO e : req.getEdges()) {
            EdgeEntity edgeEntity = new EdgeEntity();
            edgeEntity.setFromNode(e.getFrom());
            edgeEntity.setToNode(e.getTo());
            edgeEntity.setWeight(e.getWeight());
            edgeEntity.setGraph(graphEntity);
            edgeRepo.save(edgeEntity);

            graph.addEdge(e.getFrom(), e.getTo(), e.getWeight());
        }

        return graph;
    }
}
