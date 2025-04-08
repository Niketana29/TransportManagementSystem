package com.transport.app;

import com.transport.dao.TransportManagementService;
import com.transport.dao.TransportManagementServiceImpl;
import com.transport.exceptions.*;
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
                        // service.addVehicle(...);
                        break;
                    case 2:
                        // service.updateVehicle(...);
                        break;
                    case 3:
                        // service.deleteVehicle(...);
                        break;
                    case 4:
                        // service.scheduleTrip(...);
                        break;
                    case 5:
                        // service.cancelTrip(...);
                        break;
                    case 6:
                        // service.bookTrip(...);
                        break;
                    case 7:
                        // service.cancelBooking(...);
                        break;
                    case 8:
                        // service.allocateDriver(...);
                        break;
                    case 9:
                        // service.deallocateDriver(...);
                        break;
                    case 10:
                        // service.getBookingsByPassenger(...);
                        break;
                    case 11:
                        // service.getBookingsByTrip(...);
                        break;
                    case 12:
                        // service.getAvailableDrivers(...);
                        break;
                    case 13:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            //} catch (VehicleNotFoundException | BookingNotFoundException e) {
              //  System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        sc.close();
    }
}

