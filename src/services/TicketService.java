package services;

import models.*;
import models.enums.ParkingSpotStatus;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import repositories.TicketRepository;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategy;

import java.time.LocalDateTime;

public class TicketService {
    TicketRepository ticketRepository;
    ParkingSpotRepository parkingSpotRepository;
    ParkingLotRepository parkingLotRepository;
    GateRepository gateRepository;

    public TicketService(TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }

    public Ticket generateTicket(int parkingLotId, Vehicle vehicle, int gateId){

        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);

        SpotAllocationStrategy spotAllocationStrategy = parkingLot.getSpotAllocationStrategy();

        ParkingSpot parkingSpot = spotAllocationStrategy.allocateSpot(parkingLot,vehicle);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpot.setVehicle(vehicle);
        parkingSpotRepository.add(parkingSpot);

        Ticket ticket = new Ticket();
        ticket.setEntryGate(gateRepository.getGate(gateId));
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);

        ticketRepository.add(ticket);

        return ticketRepository.getTicket(ticket.getId());
    }
}
