package com.transport.entity;

public class Vehicle {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private double capacity;
    private String type;    // Bus/Truck/Van
    private String status;  // Available, Maintenance, On Trip

    // ✅ Default Constructor
    public Vehicle() {}

    // ✅ Full Parameterized Constructor
    public Vehicle(int vehicleId, String make, String model, int year, double capacity, String type, String status) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.type = type;
        this.status = status;
    }

    // ✅ Constructor for updating vehicle info (without make/year)
    public Vehicle(int vehicleId, String model, double capacity, String type, String status) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.capacity = capacity;
        this.type = type;
        this.status = status;
    }

    // Getters and Setters
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) { this.capacity = capacity; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", make=" + make + ", model=" + model + ", year=" + year
                + ", capacity=" + capacity + ", type=" + type + ", status=" + status + "]";
    }
}
