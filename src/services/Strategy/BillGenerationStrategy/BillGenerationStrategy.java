package services.Strategy.BillGenerationStrategy;

import models.Bill;
import models.Ticket;

public interface BillGenerationStrategy {

    Bill generateBill(Ticket ticket);
}
