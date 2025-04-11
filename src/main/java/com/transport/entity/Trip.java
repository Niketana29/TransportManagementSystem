package com.transport.entity;

public class Trip {
    private int tripId;
    private int vehicleId;
    private int routeId;
    private String departureDate;
    private String arrivalDate;
    private int driverId;

    // ✅ Default Constructor
    public Trip() {}

    // ✅ Full Constructor (used when scheduling a trip)
    public Trip(int tripId, int vehicleId, int routeId, String departureDate, String arrivalDate) {
        this.tripId = tripId;
        this.vehicleId = vehicleId;
        this.routeId = routeId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
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

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    @Override
    public String toString() {
        return "Trip [tripId=" + tripId + ", vehicleId=" + vehicleId + ", routeId=" + routeId
                + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", driverId=" + driverId + "]";
    }
}
