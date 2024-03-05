package models;

import models.enums.BillStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bill extends BaseClass{

    private Ticket ticket;
    private double amount;
    private LocalDateTime exitTime;
    private Gate exitGate;
    private BillStatus billStatus;

    public Bill(Ticket ticket, double amount, LocalDateTime exitTime, Gate exitGate, BillStatus billStatus) {
        this.ticket = ticket;
        this.amount = amount;
        this.exitTime = exitTime;
        this.exitGate = exitGate;
        this.billStatus = billStatus;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Bill{" +
                "\nticket=" + ticket.getId() +
                ",\n amount=" + amount +
                ",\n exitTime=" + exitTime.format(dateTimeFormatter) +
                ",\n exitGate=" + exitGate.getGateNumber() +
                ",\n billStatus=" + billStatus +
                "\n}";
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
