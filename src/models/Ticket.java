package models;

import java.time.LocalDateTime;

public class Ticket extends BaseClass{
    private int ticketNo;
    private LocalDateTime entryTime;
    private Vehical vehical;
    private Gate entryGate;
    private ParkingSpot parkingSpot;

    public Ticket(int ticketNo, LocalDateTime entryTime, Vehical vehical, Gate entryGate, ParkingSpot parkingSpot) {
        this.ticketNo = ticketNo;
        this.entryTime = entryTime;
        this.vehical = vehical;
        this.entryGate = entryGate;
        this.parkingSpot = parkingSpot;
    }
    public Ticket(){}

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehical getVehical() {
        return vehical;
    }

    public void setVehical(Vehical vehical) {
        this.vehical = vehical;
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
