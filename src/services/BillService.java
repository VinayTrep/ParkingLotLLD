package services;

import exceptions.TicketNotFoundException;
import models.*;

import models.enums.ParkingSpotStatus;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import repositories.TicketRepository;
import services.Strategy.BillGenerationStrategy.BillGenerationStrategy;

public class BillService {
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;
    ParkingSpotRepository parkingSpotRepository;
    GateRepository gateRepository;

    public BillService(ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
    }

    public Bill generateBill(int ticketId, int parkingLotId, int gateId){
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);

        BillGenerationStrategy strategy = parkingLot.getBillGenerationStrategy();
        Ticket ticket = ticketRepository.getTicket(ticketId);
        if (ticket == null){
            throw new TicketNotFoundException("Invalid ticket id");
        }

        Bill bill = strategy.generateBill(ticket);

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setVehicle(null);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpotRepository.add(parkingSpot);

        Gate gate = gateRepository.getGate(gateId);
        bill.setExitGate(gate);

        return bill;
    }
}
