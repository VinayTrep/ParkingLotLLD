package models;

import models.enums.ParkingLotStatus;
import models.enums.VehicalType;
import services.Strategy.BillGenerationStrategy.BillGenerationStrategy;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseClass{

    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private int capacity;
    private List<VehicalType> vehicalTypeSupported;
    private ParkingLotStatus parkingLotStatus;
    private SpotAllocationStrategy spotAllocationStrategy;
    private BillGenerationStrategy billGenerationStrategy;

    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloors, int capacity, List<VehicalType> vehicalTypeSupported, ParkingLotStatus parkingLotStatus, SpotAllocationStrategy spotAllocationStrategy, BillGenerationStrategy billGenerationStrategy) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.capacity = capacity;
        this.vehicalTypeSupported = vehicalTypeSupported;
        this.parkingLotStatus = parkingLotStatus;
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.billGenerationStrategy = billGenerationStrategy;
    }

    public ParkingLot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<VehicalType> getVehicalTypeSupported() {
        return vehicalTypeSupported;
    }

    public void setVehicalTypeSupported(List<VehicalType> vehicalTypeSupported) {
        this.vehicalTypeSupported = vehicalTypeSupported;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public BillGenerationStrategy getBillGenerationStrategy() {
        return billGenerationStrategy;
    }

    public void setBillGenerationStrategy(BillGenerationStrategy billGenerationStrategy) {
        this.billGenerationStrategy = billGenerationStrategy;
    }
}
