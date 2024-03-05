package controller;

import exceptions.TicketNotFoundException;
import models.Bill;
import models.Ticket;
import services.BillService;

public class BillController {

    BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill getBill(int ticketId, int parkingLotId,int gateId){
        try{
            return billService.generateBill(ticketId,parkingLotId, gateId);
        }catch (TicketNotFoundException ticketNotFoundException){
            System.out.println(ticketNotFoundException);
        }
        return null;
    };
}
