package com.transport.app;

import com.transport.dao.TransportManagementService;
import com.transport.dao.TransportManagementServiceImpl;
import com.transport.entity.Vehicle;
import java.util.Scanner;

public class TransportManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransportManagementService service = new TransportManagementServiceImpl();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Transport Management System ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Update Vehicle");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. Schedule Trip");
            System.out.println("5. Cancel Trip");
            System.out.println("6. Book Trip");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Allocate Driver");
            System.out.println("9. Deallocate Driver");
            System.out.println("10. Get Bookings by Passenger");
            System.out.println("11. Get Bookings by Trip");
            System.out.println("12. Get Available Drivers");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter vehicle make: ");
                        String make = sc.next();
                        System.out.print("Enter vehicle model: ");
                        String model = sc.next();
                        System.out.print("Enter year: ");
                        int year = sc.nextInt();
                
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setMake(make);
                        newVehicle.setModel(model);
                        newVehicle.setYear(year);
                
                        boolean added = service.addVehicle(newVehicle);
                        if (added) {
                            System.out.println("Vehicle added successfully!");
                        } else {
                            System.out.println("Failed to add vehicle.");
                        }
                        break;
                
                        case 2:
                        System.out.print("Enter Vehicle ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine(); // consume newline
                    
                        System.out.print("Enter New Vehicle Model: ");
                        String updateModel = sc.nextLine();
                    
                        System.out.print("Enter New Vehicle Capacity: ");
                        double updateCapacity = sc.nextDouble();
                        sc.nextLine();
                    
                        System.out.print("Enter New Vehicle Type (Bus/Truck/Van): ");
                        String updateType = sc.nextLine();
                    
                        System.out.print("Enter New Vehicle Status (Available/Maintenance/On Trip): ");
                        String updateStatus = sc.nextLine();
                    
                        // 🔁 Updated object creation and method call
                        Vehicle updatedVehicle = new Vehicle(updateId, updateModel, updateCapacity, updateType, updateStatus);
                        boolean isUpdated = service.updateVehicle(updatedVehicle);
                        
                        if (isUpdated) {
                            System.out.println("Vehicle updated successfully.");
                        } else {
                            System.out.println("Failed to update vehicle.");
                        }
                        break;
                    
                
                    case 3:
                        System.out.print("Enter Vehicle ID to delete: ");
                        int deleteId = sc.nextInt();
                
                        boolean deleted = service.deleteVehicle(deleteId);
                        if (deleted) {
                            System.out.println("Vehicle deleted successfully.");
                        } else {
                            System.out.println("Failed to delete vehicle.");
                        }
                        
                        break;
                
                    case 4:
                        System.out.print("Enter Vehicle ID for the trip: ");
                        int vehicleId = sc.nextInt();
                    
                        System.out.print("Enter Route ID: ");
                        int routeId = sc.nextInt();
                        sc.nextLine(); // consume newline
                    
                        System.out.print("Enter Departure Date (YYYY-MM-DD): ");
                        String departureDate = sc.nextLine();
                    
                        System.out.print("Enter Arrival Date (YYYY-MM-DD): ");
                        String arrivalDate = sc.nextLine();
                    
                        boolean scheduled = service.scheduleTrip(vehicleId, routeId, departureDate, arrivalDate);
                    
                        if (scheduled) {
                            System.out.println("Trip scheduled successfully.");
                        } else {
                            System.out.println("Failed to schedule trip.");
                        }
                        break;
                
                    case 5:
                        System.out.print("Enter Trip ID to cancel: ");
                        int tripId = sc.nextInt();
                        boolean cancelled = service.cancelTrip(tripId);
                        if (cancelled) {
                            System.out.println("Trip cancelled successfully.");
                        } else {
                            System.out.println("Failed to cancel trip.");
                        }
                        break;
                
                    case 6:
                        System.out.print("Enter Trip ID to book: ");
                        int tripIdToBook = sc.nextInt();
                        System.out.print("Enter Passenger ID: ");
                        int passengerId = sc.nextInt();
                
                        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
                        String bookingDate = sc.next();
                        
                        boolean booked = service.bookTrip(tripIdToBook, passengerId, bookingDate);
                        
                        if (booked) {
                            System.out.println("Trip booked successfully.");
                        } else {
                            System.out.println("Failed to book trip.");
                        }
                        break;
                
                    case 7:
                        System.out.print("Enter Booking ID to cancel: ");
                        int bookingId = sc.nextInt();
                
                        boolean bookingCancelled = service.cancelBooking(bookingId);
                        if (bookingCancelled) {
                            System.out.println("Booking cancelled successfully.");
                        } else {
                            System.out.println("Failed to cancel booking.");
                        }
                        break;
                
                    case 8:
                        System.out.print("Enter Trip ID to allocate driver: ");
                        int tripToAllocate = sc.nextInt();
                        System.out.print("Enter Driver ID: ");
                        int driverId = sc.nextInt();
                
                        boolean allocated = service.allocateDriver(tripToAllocate, driverId);
                        if (allocated) {
                            System.out.println("Driver allocated successfully.");
                        } else {
                            System.out.println("Failed to allocate driver.");
                        }
                        break;
                
                    case 9:
                        System.out.print("Enter Trip ID to deallocate driver: ");
                        int tripToDeallocate = sc.nextInt();
                
                        boolean deallocated = service.deallocateDriver(tripToDeallocate);
                        if (deallocated) {
                            System.out.println("Driver deallocated successfully.");
                        } else {
                            System.out.println("Failed to deallocate driver.");
                        }
                        break;
                
                    case 10:
                        System.out.print("Enter Passenger ID to view bookings: ");
                        int passengerIdForBookings = sc.nextInt();
                
                        service.getBookingsByPassenger(passengerIdForBookings).forEach(System.out::println);
                        break;
                
                    case 11:
                        System.out.print("Enter Trip ID to view bookings: ");
                        int tripIdForBookings = sc.nextInt();
                
                        service.getBookingsByTrip(tripIdForBookings).forEach(System.out::println);
                        break;
                
                    case 12:
                        System.out.println("Available Drivers:");
                        service.getAvailableDrivers().forEach(System.out::println);
                        break;
                
                    case 13:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        sc.close();
    }
}

