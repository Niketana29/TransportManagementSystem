package com.transport.entity;

public class Trip {
    private int tripId;
    private int vehicleId;
    private int routeId;
    private String departureDate;
    private String arrivalDate;
    private String status;
    private String tripType;
    private int maxPassengers;
    private int driverId;

    // Default Constructor
    public Trip() {}

    // Parameterized Constructor
    public Trip(int tripId, int vehicleId, int routeId, String departureDate, String arrivalDate) {
        this.tripId = tripId;
        this.vehicleId = vehicleId;
        this.routeId = routeId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.status = "Scheduled";  // Default status
        this.tripType = "Regular";  // Default trip type
        this.maxPassengers = 50;    // Default passenger limit
        this.driverId = 0;
    }
    

    // Getters and Setters
    public int getTripId() { return tripId; }
    public void setTripId(int tripId) { this.tripId = tripId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public int getRouteId() { return routeId; }
    public void setRouteId(int routeId) { this.routeId = routeId; }

    public String getDepartureDate() { return departureDate; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

    public String getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTripType() { return tripType; }
    public void setTripType(String tripType) { this.tripType = tripType; }

    public int getMaxPassengers() { return maxPassengers; }
    public void setMaxPassengers(int maxPassengers) { this.maxPassengers = maxPassengers; }

    public int getDriverId() {
        return driverId;
    }

    // ✅ Add setDriverId() method
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}

