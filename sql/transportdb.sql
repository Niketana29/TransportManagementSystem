 CREATE DATABASE IF NOT EXISTS TransportDB;
USE TransportDB;

-- 🚗 Vehicles Table
CREATE TABLE Vehicles (
    VehicleID INT AUTO_INCREMENT PRIMARY KEY,
    Model VARCHAR(255) NOT NULL,
    Capacity DECIMAL(10, 2) NOT NULL,
    Type VARCHAR(50) NOT NULL CHECK (Type IN ('Truck', 'Van', 'Bus')),
    Status VARCHAR(50) NOT NULL CHECK (Status IN ('Available', 'On Trip', 'Maintenance'))
);

-- 📍 Routes Table
CREATE TABLE Routes (
    RouteID INT AUTO_INCREMENT PRIMARY KEY,
    StartDestination VARCHAR(255) NOT NULL,
    EndDestination VARCHAR(255) NOT NULL,
    Distance DECIMAL(10, 2) NOT NULL
);

-- 🚌 Trips Table
CREATE TABLE Trips (
    TripID INT AUTO_INCREMENT PRIMARY KEY,
    VehicleID INT NOT NULL,
    RouteID INT NOT NULL,
    DepartureDate DATETIME NOT NULL,
    ArrivalDate DATETIME NOT NULL,
    Status VARCHAR(50) NOT NULL CHECK (Status IN ('Scheduled', 'In Progress', 'Completed', 'Cancelled')),
    TripType VARCHAR(50) DEFAULT 'Freight' CHECK (TripType IN ('Freight', 'Passenger')),
    MaxPassengers INT CHECK (MaxPassengers >= 0),
    FOREIGN KEY (VehicleID) REFERENCES Vehicles(VehicleID) ON DELETE CASCADE,
    FOREIGN KEY (RouteID) REFERENCES Routes(RouteID) ON DELETE CASCADE
);

-- 👤 Passengers Table
CREATE TABLE Passengers (
    PassengerID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    Gender VARCHAR(50) CHECK (Gender IN ('Male', 'Female', 'Other')),
    Age INT CHECK (Age >= 0),
    Email VARCHAR(255) UNIQUE NOT NULL,
    PhoneNumber VARCHAR(50) NOT NULL
);

-- 🎫 Bookings Table
CREATE TABLE Bookings (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    TripID INT NOT NULL,
    PassengerID INT NOT NULL,
    BookingDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Status VARCHAR(50) NOT NULL CHECK (Status IN ('Confirmed', 'Cancelled', 'Completed')),
    FOREIGN KEY (TripID) REFERENCES Trips(TripID) ON DELETE CASCADE,
    FOREIGN KEY (PassengerID) REFERENCES Passengers(PassengerID) ON DELETE CASCADE
);


SHOW TABLES;
INSERT INTO Vehicles (Model, Capacity, Type, Status) VALUES 
('Volvo Truck', 15.5, 'Truck', 'Available'),
('Mercedes Bus', 50.0, 'Bus', 'On Trip');
INSERT INTO Routes (StartDestination, EndDestination, Distance) VALUES
('New York', 'Los Angeles', 4500.50),
('Chicago', 'Houston', 1500.30);
INSERT INTO Trips (VehicleID, RouteID, DepartureDate, ArrivalDate, Status, TripType, MaxPassengers) VALUES
(1, 1, '2025-03-20 08:00:00', '2025-03-25 18:00:00', 'Scheduled', 'Freight', 0),
(2, 2, '2025-03-21 09:00:00', '2025-03-22 15:00:00', 'Scheduled', 'Passenger', 50);
INSERT INTO Passengers (FirstName, Gender, Age, Email, PhoneNumber) VALUES
('Alice', 'Female', 28, 'alice@example.com', '123-456-7890'),
('Bob', 'Male', 35, 'bob@example.com', '987-654-3210');
INSERT INTO Bookings (TripID, PassengerID, BookingDate, Status) VALUES
(2, 1, '2025-03-18 12:30:00', 'Confirmed'),
(2, 2, '2025-03-18 14:00:00', 'Confirmed');
SELECT * FROM ROUTES;


