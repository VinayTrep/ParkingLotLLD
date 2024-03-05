package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket extends BaseClass{
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private Gate entryGate;
    private ParkingSpot parkingSpot;

    public Ticket( LocalDateTime entryTime, Vehicle vehicle, Gate entryGate, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.entryGate = entryGate;
        this.parkingSpot = parkingSpot;
    }
    public Ticket(){}

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Ticket{ \n" +
                "TicketId=" + getId() +
                "\n entryTime=" + entryTime.format(formatter) +
                ",\n vehicle=" + vehicle.getVehicleNumber() +
                ",\n entryGate=" + entryGate.getGateNumber() +
                "\n, parkingSpot=" + parkingSpot.getSpotNumber() +
                "\n}";
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
