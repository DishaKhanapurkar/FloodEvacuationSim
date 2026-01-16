import * as L from 'leaflet';
import { Component, AfterViewInit } from '@angular/core';
import { GraphNode, GraphService } from '../graph.service';

@Component({
  selector: 'app-map',
  standalone: true,
  template: `<div id="map" style="height: 100%;"></div>`
})
export class MapComponent implements AfterViewInit {

  private map!: L.Map;
  private nodeId = 1;
  private selectedNodeId: number | null = null;
  private safePathLine?: L.Polyline;

  constructor(private graphService: GraphService) {}

  ngAfterViewInit(): void {
    this.map = L.map('map').setView([12.9716, 77.5946], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '© OpenStreetMap'
    }).addTo(this.map);

    this.map.on('click', (e: any) => this.addNode(e));

    // redraw safe path periodically
    setInterval(() => this.drawSafePath(), 500);

    setTimeout(() => this.map.invalidateSize(), 0);
  }

  addNode(e: any) {
    const node: GraphNode = {
      id: this.nodeId++,
      x: e.latlng.lat,
      y: e.latlng.lng
    };

    this.graphService.addNode(node);

    const marker = L.marker([node.x, node.y], {
      icon: L.divIcon({
        className: 'node-label',
        html: `<div>Point ${node.id}</div>`,
        iconSize: [60, 20]
      })
    }).addTo(this.map);

    marker.on('click', () => this.handleNodeClick(node.id));
  }

  handleNodeClick(nodeId: number) {
    if (this.selectedNodeId === null) {
      this.selectedNodeId = nodeId;
      return;
    }

    if (this.selectedNodeId === nodeId) return;

    const nodes = this.graphService.getNodes();
    const n1 = nodes.find(n => n.id === this.selectedNodeId)!;
    const n2 = nodes.find(n => n.id === nodeId)!;

    const weight = Math.round(
      this.map.distance([n1.x, n1.y], [n2.x, n2.y])
    );

    this.graphService.addEdge({
      from: n1.id,
      to: n2.id,
      weight
    });

    L.polyline([[n1.x, n1.y], [n2.x, n2.y]], { color: 'blue' })
      .addTo(this.map);

    this.selectedNodeId = null;
  }

  drawSafePath() {
    const path = this.graphService.getSafePath();
    if (path.length < 2) return;

    if (this.safePathLine) {
      this.map.removeLayer(this.safePathLine);
    }

    const latlngs = path.map(id => {
      const n = this.graphService.getNodes().find(x => x.id === id)!;
      return [n.x, n.y] as [number, number];
    });

    this.safePathLine = L.polyline(latlngs, {
      color: 'green',
      weight: 5
    }).addTo(this.map);
  }
}
