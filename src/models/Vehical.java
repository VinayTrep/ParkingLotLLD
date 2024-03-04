package models;

import models.enums.VehicalType;

public class Vehical extends BaseClass{
    private String vehicalNumber;
    private VehicalType vehicalType;
    private String color;

    public Vehical(String vehicalNumber, VehicalType vehicalType, String color) {
        this.vehicalNumber = vehicalNumber;
        this.vehicalType = vehicalType;
        this.color = color;
    }

    public Vehical() {
    }

    public String getVehicalNumber() {
        return vehicalNumber;
    }

    public void setVehicalNumber(String vehicalNumber) {
        this.vehicalNumber = vehicalNumber;
    }

    public VehicalType getVehicalType() {
        return vehicalType;
    }

    public void setVehicalType(VehicalType vehicalType) {
        this.vehicalType = vehicalType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
