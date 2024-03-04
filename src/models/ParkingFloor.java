package models;

import models.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseClass{

    private int floorNumber;
    private List<ParkingSpot> parkingSpotList;
    private Gate entryGate;
    private Gate exitGate;
    private ParkingFloorStatus parkingFloorStatus;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpotList, Gate entryGate, Gate exitGate, ParkingFloorStatus parkingFloorStatus) {
        this.floorNumber = floorNumber;
        this.parkingSpotList = parkingSpotList;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public ParkingFloor() {
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
