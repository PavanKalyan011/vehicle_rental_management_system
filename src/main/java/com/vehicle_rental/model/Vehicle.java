package com.vehicle_rental.model;

public class Vehicle {
    private int vehicleId;
    private String model;
    private String brand;
    private double pricePerDay;
    private boolean availability;

    public Vehicle(int vehicleId, String model, String brand, double pricePerDay, boolean availability) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.availability = availability;
    }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(double pricePerDay) { this.pricePerDay = pricePerDay; }

    public boolean isAvailable() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }
}
