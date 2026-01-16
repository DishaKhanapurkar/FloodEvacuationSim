import { Injectable } from '@angular/core';

export interface GraphNode {
  id: number;
  x: number; // latitude
  y: number; // longitude
}

export interface GraphEdge {
  from: number;
  to: number;
  weight: number;
}

@Injectable({
  providedIn: 'root'
})
export class GraphService {

  private nodes: GraphNode[] = [];
  private edges: GraphEdge[] = [];

  private safePath: number[] = [];
  private safePathTime: number = -1;

  /* ---------- Graph ---------- */
  addNode(node: GraphNode) {
    this.nodes.push(node);
  }

  addEdge(edge: GraphEdge) {
    this.edges.push(edge);
  }

  getNodes(): GraphNode[] {
    return this.nodes;
  }

  getEdges(): GraphEdge[] {
    return this.edges;
  }

  /* ---------- Safe Path Result ---------- */
  setSafePath(path: number[], time: number) {
    this.safePath = path;
    this.safePathTime = time;
  }

  getSafePath(): number[] {
    return this.safePath;
  }

  getSafePathTime(): number {
    return this.safePathTime;
  }
}
