package com.transport.main;

import com.transport.dao.VehicleDAO;
import com.transport.entity.Vehicle;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VehicleDAO vehicleDAO = new VehicleDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Transport Management System ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    viewAllVehicles();
                    break;
                case 3:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addVehicle() {
        System.out.print("Enter Vehicle Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Vehicle Capacity: ");
        double capacity = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Vehicle Type (Bus/Truck/Van): ");
        String type = scanner.nextLine();
        System.out.print("Enter Vehicle Status (Available/Maintenance/On Trip): ");
        String status = scanner.nextLine();

        Vehicle vehicle = new Vehicle(0, model, capacity, type, status);
        if (vehicleDAO.addVehicle(vehicle)) {
            System.out.println("Vehicle added successfully!");
        } else {
            System.out.println("Failed to add vehicle.");
        }
    }

    private static void viewAllVehicles() {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("\n=== Vehicle List ===");
            for (Vehicle v : vehicles) {
                System.out.println("ID: " + v.getVehicleId() + ", Model: " + v.getModel() +
                        ", Capacity: " + v.getCapacity() + ", Type: " + v.getType() +
                        ", Status: " + v.getStatus());
            }
        }
    }
}
