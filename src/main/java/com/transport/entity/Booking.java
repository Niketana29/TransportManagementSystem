package com.transport.entity;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private int tripId;
    private int passengerId;
    private LocalDateTime bookingDate;
    private String status;

    // ✅ Default Constructor
    public Booking() {}

    // ✅ Parameterized Constructor
    public Booking(int bookingId, int tripId, int passengerId, String status) {
        this.bookingId = bookingId;
        this.tripId = tripId;
        this.passengerId = passengerId;
        this.bookingDate = LocalDateTime.now();
        this.status = status;
    }

    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getTripId() { return tripId; }
    public void setTripId(int tripId) { this.tripId = tripId; }

    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", tripId=" + tripId + ", passengerId=" + passengerId
                + ", bookingDate=" + bookingDate + ", status=" + status + "]";
    }
}
