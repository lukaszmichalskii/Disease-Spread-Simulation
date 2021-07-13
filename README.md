# Disease Spread Simulation


## Description

The task of this project was to create an application simulating the spread of infectious diseases, which could give user opportunity to see how the disease spreads depending on the given parameters. The simulation also provides an optional opportunity to see what the infections/death charts look like. 

## Features
The simulation process depends on several parameters (set by the user) like:
- population size
- disease mortality index
- initial number of virus carriers
- people's initial behavior (some may pay more attention to virus threat)


Application gives possibility to set two optional functions like:
- charts of deaths and infections
- simple behavior imitating social distancing when the government decided to introduce restrictions


**social distanceing** behavior is based on the Craig Reynolds Boids algorithm (the principle of separation) for more information see:
1. [Boids - Stanford Computer Science](https://cs.stanford.edu/people/eroberts/courses/soco/projects/2008-09/modeling-natural-systems/boids.html)
2. [Boids - Wikipedia](https://en.wikipedia.org/wiki/Boids)
3. [The Nature of Code](https://natureofcode.com/book/chapter-6-autonomous-agents/)
## Tech

Disease Spread Simulation is made in Java with the help of the Gradle build automation tool

## Images

### Simulation in action (screenshot)

![SimulationprocessScreen](https://user-images.githubusercontent.com/76202883/125428787-c9574056-89e3-46cd-a25e-a1a7528d39ca.png)

### Configuration screen

![configScreen_70](https://user-images.githubusercontent.com/76202883/125428752-8df088b9-6ad4-452a-9f54-7b3ca96cbb8e.png)


