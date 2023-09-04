# Vehicle GPS Tracking System

This is a backend system for tracking GPS coordinates of vehicles, managing vehicle and owner information, and providing various useful functionalities.


## Features

1. Store and manage GPS coordinates of vehicles.
2. Retrieve GPS information for a specific vehicle.
3. Calculate distance traveled between two dates.
4. Access vehicle information for a specific user.
5. Manage multiple vehicles for a single user.

## Database Schema

- `vehicles`: Table to store vehicle information.
- `owners`: Table to store owner information.
- `gps_coordinates`: Table to store GPS coordinates with a foreign key reference to `vehicles`.

## API Documentation
## GPS API'S
### 1. Store GPS Coordinates
- **URL**: `http://localhost:8080/gps/coordinates/{vehicleID}`
- **Method**: POST
- **Request Body**: JSON data containing GPS coordinates.
- **Authentication**: Required
- **Description**: Store GPS coordinates for a vehicle.

### 2. Get GPS Information
- **URL**: `http://localhost:8080/gps/getcoordinates?vehicleId={vehicleID}&ownerId={ownerID}`
- **Method**: GET
- **Description**: Retrieve GPS information for a specific vehicle.

### 3. Calculate Distance Traveled
- **URL**: `http://localhost:8080/gps/getDistanceTraveled?startDate=2022-09-01T09:25:50&endDate= 2024-09-01T09:25:50&vehicleId={vehicleID}`
- **Method**: GET
- **Parameters**: `startDate`, `endDate`
- **Description**: Calculate distance traveled for a vehicle between two dates.

### 4. Access Vehicle Information
- **URL**: `http://localhost:8080/gps/getcoordinates?vehicleId={vehicleID}&ownerId={ownerID}`
- **Method**: GET
- **Description**: Retrieve a list of vehicles owned by a user.

  
## Owner API'S
### 1. Store Owner Details
- **URL**: `http://localhost:8080/gps/getcoordinates?vehicleId={vehicleId}&ownerId={OwnerId}`
- **Method**: POST
- **Request Body**: JSON data containing Owner Details.
- **Parameters**: `vehicleId`, `OwnerId`
- **Description**:  Store Owner Details.
- 
### 2. Upate vehicle Owner Details
- **URL**: `http://localhost:8080/vehicle/assignOwner?vehicleId={vehicleId}&ownerId={OwnerId}`
- **Method**: POST
- **Parameters**: `vehicleId`, `OwnerId`
- **Description**:  Upate vehicle Owner Details.

## Vehicle API'S
### 1. Create Vehicle Details
- **URL**: `http://localhost:8080/vehicle/create`
- **Method**: POST
- **Request Body**: JSON data containing Vehicle Details.
- **Description**:  Store Owner Details.

## Installation
1. Clone this repository.
2. et up your database
3. Set up your development environment.
4. Configure your application properties in `application.properties`  files.
5. Build and run the project using [Maven](https://maven.apache.org/) .

## Usage

1. Start the application and make sure it's running.
2. Use the provided API endpoints as documented above.

