package com.transport.dao;

import com.transport.entity.Vehicle;
import com.transport.utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public boolean addVehicle(Vehicle vehicle) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Vehicles (Model, Capacity, Type, Status) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, vehicle.getModel());
            stmt.setDouble(2, vehicle.getCapacity());
            stmt.setString(3, vehicle.getType());
            stmt.setString(4, vehicle.getStatus());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Vehicles")) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                    rs.getInt("VehicleID"),
                    rs.getString("Model"),
                    rs.getDouble("Capacity"),
                    rs.getString("Type"),
                    rs.getString("Status")
                );
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}

