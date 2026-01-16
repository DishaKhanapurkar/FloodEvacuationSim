# FloodEvacuationSimulation

🌊 Flood Evacuation Route Planner

A time-aware evacuation planning system that computes the earliest safe route in the presence of flooding, using graph algorithms and a full-stack architecture.

The system models a city as a weighted graph, simulates flood propagation, and determines evacuation routes that ensure arrival before flooding reaches each location.

🚀 Features

📍 Interactive map-based graph creation (nodes & roads)

🧠 Safe evacuation path computation using constrained Dijkstra

🟢 Visualization of the safest evacuation route on the map

⚙️ Full-stack implementation with REST APIs and database persistence

🧠 Core Idea

In real-world evacuation scenarios, the shortest path is not always safe.

This project computes:

Flood arrival times at each location

Evacuation paths that ensure a person reaches every node before flood arrival

Among all safe paths, the system selects the earliest-arrival route, which may or may not be the shortest.

🧮 Algorithm Overview
Safe Path Computation

Uses Dijkstra’s algorithm

Adds a safety constraint:

arrivalTime(node) < floodArrivalTime(node)


Paths violating this condition are discarded

Among remaining paths, the earliest-arrival path is selected

This approach ensures correctness while reflecting real evacuation constraints.

🏗️ Architecture
Angular + Leaflet (UI)
        |
        v
Spring Boot REST APIs
        |
        v
PostgreSQL Database

Frontend

Angular 21 (standalone components)

Leaflet + OpenStreetMap for visualization

Interactive control panel for simulations

Backend

Spring Boot microservices

Flood simulation & safe path computation

Clean DTO-based API design

Database

PostgreSQL

Stores graph structure and simulation data

<img width="1600" height="824" alt="image" src="https://github.com/user-attachments/assets/2b615cd3-96ed-42a3-b8cd-43ef9e10bd01" />



<img width="1918" height="1013" alt="image" src="https://github.com/user-attachments/assets/484acba1-5b7b-4afe-aec5-af6733b5e78a" />


📊 Example Scenario

A shorter route passes through low-lying roads

Flood reaches these roads early

A longer detour remains dry long enough

The system correctly selects the longer but safer route

This demonstrates why shortest path ≠ safest path in disaster scenarios.



▶️ How to Run the Project
Backend
cd backend
./mvnw spring-boot:run

Frontend
cd frontend
npm install
ng serve


🔮 Possible Extensions

Multiple flood sources

Variable flood speed per road

Human speed vs flood speed

Animated flood visualization

Shelter nodes immune to flooding


