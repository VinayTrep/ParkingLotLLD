package models;

import models.enums.BillStatus;

import java.time.LocalDateTime;

public class Bill extends BaseClass{

    private int billNumber;
    private Ticket ticket;
    private double amount;
    private LocalDateTime exitTime;
    private Gate exitGate;
    private BillStatus billStatus;

    public Bill(int billNumber, Ticket ticket, double amount, LocalDateTime exitTime, Gate exitGate, BillStatus billStatus) {

        this.billNumber = billNumber;
        this.ticket = ticket;
        this.amount = amount;
        this.exitTime = exitTime;
        this.exitGate = exitGate;
        this.billStatus = billStatus;
    }

    public Bill() {
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
