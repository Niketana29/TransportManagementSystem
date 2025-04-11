package com.transport.entity;

public class Driver {
    private int driverId;
    private String name;
    private String licenseNumber;
    private boolean available;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver [driverId=" + driverId + ", name=" + name + ", licenseNumber=" + licenseNumber + ", available=" + available + "]";
    }
}
