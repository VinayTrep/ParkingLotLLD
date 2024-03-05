package models;

import models.enums.VehicleType;

public class Vehicle extends BaseClass{
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String color;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, String color) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public Vehicle() {
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

