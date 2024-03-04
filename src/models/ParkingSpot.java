package models;

import models.enums.ParkingSpotStatus;
import models.enums.VehicalType;

public class ParkingSpot extends BaseClass {

    private int spotNumber;
    private VehicalType vehicalType;
    private Vehical vehical;
    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot(int spotNumber, VehicalType vehicalType, Vehical vehical, ParkingSpotStatus parkingSpotStatus) {
        this.spotNumber = spotNumber;
        this.vehicalType = vehicalType;
        this.vehical = vehical;
        this.parkingSpotStatus = parkingSpotStatus;
    }
    public ParkingSpot(){

    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VehicalType getVehicalType() {
        return vehicalType;
    }

    public void setVehicalType(VehicalType vehicalType) {
        this.vehicalType = vehicalType;
    }

    public Vehical getVehical() {
        return vehical;
    }

    public void setVehical(Vehical vehical) {
        this.vehical = vehical;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
