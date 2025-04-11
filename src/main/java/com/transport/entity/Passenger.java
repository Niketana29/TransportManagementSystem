package com.transport.entity;

public class Passenger {
    private int passengerId;
    private String name;
    private String contactNumber;

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", name=" + name + ", contactNumber=" + contactNumber + "]";
    }
}
