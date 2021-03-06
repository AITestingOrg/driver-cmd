# driver-cmd

Driver Command manages drivers.

## Features
* Create Drivers

# Demo
To run this project from docker:
* Make sure that the Docker daemon is installed and running.
* Assemble this project.
* Run ```docker-compose up --build``` from the root project.
* On another terminal run ```docker ps``` to see which ports were assigned.

# Development

## Requirements
* Docker 17.xx.x
* JDK 1.8
* IntelliJ 2018
* Mongo 3.4

 To run this project from docker:
 * Make sure that the Docker daemon is installed and running.
 * Assemble this project.
 * Run ```docker-compose up --build -f docker-compose-dev.yml``` from the root project.
 * Run the Gradle task 'application/bootrun' from IntelliJ.
 
 # Swagger.
 
 With the app running, go to http://localhost:8080/swagger-ui.html or the corresponding port for it to see the UI or head to http://localhost:8080/v2/api-docs to adquire the source json.