package com.transport.entity;

/**
 * Represents a route with starting and ending destinations.
 */
public class Route {
    private int routeId;
    private String startDestination;
    private String endDestination;
    private double distance;

    // Default Constructor
    public Route() {}

    // Parameterized Constructor
    public Route(int routeId, String startDestination, String endDestination, double distance) {
        this.routeId = routeId;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.distance = distance;
    }

    // Getters and Setters
    public int getRouteId() { return routeId; }
    public void setRouteId(int routeId) { this.routeId = routeId; }

    public String getStartDestination() { return startDestination; }
    public void setStartDestination(String startDestination) { this.startDestination = startDestination; }

    public String getEndDestination() { return endDestination; }
    public void setEndDestination(String endDestination) { this.endDestination = endDestination; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
}
