import { Component } from '@angular/core';
import { MapComponent } from './map/map';
import { ControlPanelComponent } from './control-panel/control-panel';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MapComponent, ControlPanelComponent],
  template: `
    <h2>Flood Evacuation Simulation</h2>
    <div class="layout">
      <div class="map-container">
        <app-map></app-map>
      </div>
      <app-control-panel></app-control-panel>
    </div>
  `,
  styles: [`
    .layout { display: flex; height: 90vh; }
    .map-container { flex: 1; }
    app-control-panel { width: 300px; }
  `]
})
export class AppComponent {}
