package com.transport.dao;

import com.transport.entity.*;

import java.util.ArrayList;
import java.util.List;

public class TransportManagementServiceImpl implements TransportManagementService {

    private List<Vehicle> vehicleList = new ArrayList<>();
    private List<Trip> tripList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();
    private List<Driver> driverList = new ArrayList<>();

    private int vehicleIdCounter = 1;
    private int tripIdCounter = 1;
    private int bookingIdCounter = 1;

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        vehicle.setVehicleId(vehicleIdCounter++);
        return vehicleList.add(vehicle);
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getVehicleId() == vehicle.getVehicleId()) {
                vehicleList.set(i, vehicle);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteVehicle(int vehicleId) {
        return vehicleList.removeIf(vehicle -> vehicle.getVehicleId() == vehicleId);
    }

    @Override
    public boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate) {
        // Optional: Check if vehicle exists
        boolean exists = vehicleList.stream().anyMatch(v -> v.getVehicleId() == vehicleId);
        if (!exists) return false;

        Trip newTrip = new Trip(tripIdCounter++, vehicleId, routeId, departureDate, arrivalDate);
        return tripList.add(newTrip);
    }

    @Override
    public boolean cancelTrip(int tripId) {
        // Remove trip
        boolean removed = tripList.removeIf(trip -> trip.getTripId() == tripId);
        if (removed) {
            // Also remove associated bookings (optional)
            bookingList.removeIf(b -> b.getTripId() == tripId);
        }
        return removed;
    }

    @Override
    public boolean bookTrip(int tripId, int passengerId, String bookingDate) {
        // Check if trip exists
        boolean exists = tripList.stream().anyMatch(t -> t.getTripId() == tripId);
        if (!exists) return false;

        Booking newBooking = new Booking(bookingIdCounter++, tripId, passengerId, bookingDate);
        return bookingList.add(newBooking);
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        return bookingList.removeIf(booking -> booking.getBookingId() == bookingId);
    }

    @Override
    public boolean allocateDriver(int tripId, int driverId) {
        // Check if driver exists
        Driver driver = null;
        for (Driver d : driverList) {
            if (d.getDriverId() == driverId) {
                driver = d;
                break;
            }
        }
        if (driver == null) return false;

        // Check if already allocated to another trip
        for (Trip t : tripList) {
            if (t.getDriverId() == driverId) return false;
        }

        for (Trip trip : tripList) {
            if (trip.getTripId() == tripId) {
                trip.setDriverId(driverId);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deallocateDriver(int tripId) {
        for (Trip trip : tripList) {
            if (trip.getTripId() == tripId) {
                trip.setDriverId(0); // 0 = no driver assigned
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Booking> getBookingsByPassenger(int passengerId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getPassengerId() == passengerId) {
                result.add(booking);
            }
        }
        return result;
    }

    @Override
    public List<Booking> getBookingsByTrip(int tripId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getTripId() == tripId) {
                result.add(booking);
            }
        }
        return result;
    }

    @Override
    public List<Driver> getAvailableDrivers() {
        List<Driver> availableDrivers = new ArrayList<>(driverList);
        for (Trip trip : tripList) {
            if (trip.getDriverId() != 0) {
                availableDrivers.removeIf(d -> d.getDriverId() == trip.getDriverId());
            }
        }
        return availableDrivers;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    // Optional utility: to populate drivers
    public void addDriver(Driver driver) {
        driverList.add(driver);
    }
}
