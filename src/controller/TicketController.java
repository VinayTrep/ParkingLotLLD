package controller;

import exceptions.GateIDNotFoundException;
import models.Ticket;
import models.Vehicle;
import services.TicketService;

public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket getTicket(int parkingLotId, Vehicle vehicle, int gateId){

        if (gateId <=0){
            throw new GateIDNotFoundException("Invalid gate id");
        }
        return ticketService.generateTicket(parkingLotId,vehicle,gateId);
    }
}
