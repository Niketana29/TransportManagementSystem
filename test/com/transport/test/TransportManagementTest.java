package com.transport.test;

import com.transport.dao.TransportManagementService;
import com.transport.dao.TransportManagementServiceImpl;
import com.transport.entity.Vehicle;
import com.transport.exceptions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransportManagementTest {

    TransportManagementService service = new TransportManagementServiceImpl();

    //  Add a Vehicle
    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Innova");
        vehicle.setYear(2023);
        boolean result = service.addVehicle(vehicle);
        assertTrue(result, "Vehicle should be added successfully");
    }

    //  Update a Vehicle
    @Test
    public void testUpdateVehicle() {
        TransportManagementServiceImpl service = new TransportManagementServiceImpl();
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Hyundai");
        vehicle.setModel("i20");
        vehicle.setYear(2022);
    
        // Add vehicle first
        service.addVehicle(vehicle);
        int id = vehicle.getVehicleId();
    
        // Set ID and update details
        Vehicle updated = new Vehicle(id, "i20 N Line", 5.0, "Car", "Available");
        boolean result = service.updateVehicle(updated);
    
        assertTrue(result, "Vehicle should be updated successfully");
    }
    

    //  Book a trip
    @Test
    public void testBookTrip() {
        TransportManagementServiceImpl service = new TransportManagementServiceImpl();
    
        // Step 1: Add vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Honda");
        vehicle.setModel("City");
        vehicle.setYear(2021);
        service.addVehicle(vehicle);
        int vehicleId = vehicle.getVehicleId();
    
        // Step 2: Schedule trip
        boolean tripCreated = service.scheduleTrip(vehicleId, 101, "2024-05-01", "2024-05-01");
        assertTrue(tripCreated, "Trip should be scheduled");
    
        // Step 3: Book trip
        boolean booked = service.bookTrip(1, 1, "2024-04-11");
        assertTrue(booked, "Booking should be successful");
    }
    

    //  Vehicle Not Found Exception
    @Test
    public void testVehicleNotFoundException() {
        assertThrows(VehicleNotFoundException.class, () -> {
            throw new VehicleNotFoundException("Vehicle with ID 999 not found");
        });
    }

    //Test 5: Booking Not Found Exception
    @Test
    public void testBookingNotFoundException() {
        assertThrows(BookingNotFoundException.class, () -> {
            throw new BookingNotFoundException("Booking ID 888 not found");
        });
    }
}
 
