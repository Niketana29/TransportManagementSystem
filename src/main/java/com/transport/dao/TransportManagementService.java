package com.transport.dao;

import com.transport.entity.Booking;
import com.transport.entity.Driver;
import com.transport.entity.Vehicle;

import java.util.List;

public interface TransportManagementService {
    
    boolean addVehicle(Vehicle vehicle);

    boolean updateVehicle(Vehicle vehicle);

    boolean deleteVehicle(int vehicleId);

    boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate);

    boolean cancelTrip(int tripId);

    boolean bookTrip(int tripId, int passengerId, String bookingDate);

    boolean cancelBooking(int bookingId);

    boolean allocateDriver(int tripId, int driverId);

    boolean deallocateDriver(int tripId);

    List<Booking> getBookingsByPassenger(int passengerId);

    List<Booking> getBookingsByTrip(int tripId);

    List<Driver> getAvailableDrivers();
}

