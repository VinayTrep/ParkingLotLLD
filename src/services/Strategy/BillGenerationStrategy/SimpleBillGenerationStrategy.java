package services.Strategy.BillGenerationStrategy;

import models.Bill;
import models.Ticket;
import models.enums.BillStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleBillGenerationStrategy implements BillGenerationStrategy{
    @Override
    public Bill generateBill(Ticket ticket) {

        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        double amount = Math.abs(ChronoUnit.SECONDS.between(exitTime, entryTime));

        Bill bill = new Bill();
        bill.setBillStatus(BillStatus.UNPAID);
        bill.setTicket(ticket);
        bill.setAmount(amount);
        bill.setExitTime(exitTime);

        return bill;
    }
}
