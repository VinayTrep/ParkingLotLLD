package repositories;

import exceptions.TicketNotFoundException;
import models.Ticket;
import java.util.HashMap;

public class TicketRepository {
    private final HashMap<Integer, Ticket> ticketHashMap;
    public static TicketRepository instance;
    private static int id = 0;

    private TicketRepository() {
        this.ticketHashMap = new HashMap<>();
    }
    public static TicketRepository getInstance(){
        if (instance == null){
            instance = new TicketRepository();
        }
        return instance;
    }

    public void add(Ticket ticket){
        ticket.setId(++id);
        ticketHashMap.put(ticket.getId(),ticket);
    }

    public Ticket getTicket(int ticketId){
        Ticket ticket = ticketHashMap.get(ticketId);

        if (ticket == null){
            throw new TicketNotFoundException("The ticket with ticketId " + ticketId + " does not exist");
        }
        return ticket;
    }
}
