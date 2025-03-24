package com.transport.entity;

public class Vehicle {
    private int vehicleId;
    private String model;
    private double capacity;
    private String type;
    private String status; 

    public Vehicle(int vehicleId, String model, double capacity, String type, String status) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.capacity = capacity;
        this.type = type;
        this.status = status;
    }

    public int getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public double getCapacity() { return capacity; }
    public String getType() { return type; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}

