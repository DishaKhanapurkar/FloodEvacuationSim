import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GraphNode, GraphEdge } from './graph.service';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private BASE_URL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  simulateFlood(
    nodes: GraphNode[],
    edges: GraphEdge[],
    sources: number[],
    speed: number
  ) {
    return this.http.post(`${this.BASE_URL}/flood/simulate`, {
      graph: {
        nodes: nodes.map(n => ({ id: n.id, x: n.x, y: n.y })),
        edges: edges.map(e => ({ from: e.from, to: e.to, weight: e.weight }))
      },
      flood: { sources, speed }
    });
  }

  findSafePath(
    nodes: GraphNode[],
    edges: GraphEdge[],
    sources: number[],
    speed: number,
    start: number,
    end: number
  ) {
    return this.http.post(`${this.BASE_URL}/path/safe`, {
      graph: {
        nodes: nodes.map(n => ({ id: n.id, x: n.x, y: n.y })),
        edges: edges.map(e => ({ from: e.from, to: e.to, weight: e.weight }))
      },
      flood: { sources, speed },
      path: { start, end }
    });
  }
}
