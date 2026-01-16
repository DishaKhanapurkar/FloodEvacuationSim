import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { GraphService, GraphNode } from '../graph.service';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-control-panel',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './control-panel.html',
  styleUrls: ['./control-panel.css']
})
export class ControlPanelComponent {

  floodSpeed = 1;
  floodSources: number[] = [];
  startNode?: number;
  endNode?: number;

  constructor(
    private graphService: GraphService,
    private apiService: ApiService
  ) {}

  get nodes(): GraphNode[] {
    return this.graphService.getNodes();
  }

  toggleFloodSource(id: number, checked: boolean) {
    if (checked) this.floodSources.push(id);
    else this.floodSources = this.floodSources.filter(x => x !== id);
  }

  runFloodSimulation() {
    this.apiService.simulateFlood(
      this.graphService.getNodes(),
      this.graphService.getEdges(),
      this.floodSources,
      this.floodSpeed
    ).subscribe(res => console.log('Flood result:', res));
  }

  runPathSimulation() {
    if (!this.startNode || !this.endNode) {
      alert('Select start and end nodes');
      return;
    }

    this.apiService.findSafePath(
      this.graphService.getNodes(),
      this.graphService.getEdges(),
      this.floodSources,
      this.floodSpeed,
      this.startNode,
      this.endNode
    ).subscribe((res: any) => {
      this.graphService.setSafePath(res.path, res.time);
      alert(`Safe path time: ${res.time}`);
    });
  }
}
