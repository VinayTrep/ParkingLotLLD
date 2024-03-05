import controller.BillController;
import controller.InitialisationController;
import controller.TicketController;
import models.Bill;
import models.Ticket;
import models.Vehicle;
import models.enums.BillStatus;
import models.enums.VehicleType;
import repositories.*;
import services.BillService;
import services.InitialisationService;
import services.TicketService;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();
        ParkingFloorRepository parkingFloorRepository = ParkingFloorRepository.getInstance();
        InitialisationService initialisationService = getInitialisationService(parkingLotRepository, parkingFloorRepository);

        InitialisationController initialisationController = new InitialisationController(initialisationService);

        initialisationController.init();


        System.out.println("Welcome to Parking Lot");

        while(true){
            System.out.println("Choose your action 1) Enter Parking Lot 2) exit parking lot");
            int choice = Integer.parseInt(sc.next());

            if (choice == 1){
                System.out.println("Enter the parking lot number");
                int parkingLotID = Integer.parseInt(sc.next());
                System.out.println("Enter the gate Id");
                int gateId = Integer.parseInt(sc.next());
                Vehicle vehicle = new Vehicle();
                System.out.println("Enter Vehicle details....");
                System.out.println("Enter Vehicle Type");
                System.out.println("1) CAR 2)BIKE");
                int vehicleType = Integer.parseInt(sc.next());
                if (vehicleType == 1){
                    vehicle.setVehicleType(VehicleType.CAR);
                } else if (vehicleType == 2) {
                    vehicle.setVehicleType(VehicleType.BIKE);
                }

                System.out.println("Enter vehicle color");
                String color = sc.next();
                vehicle.setColor(color);

                System.out.println("enter vehicle number");
                String vehicleNumber = sc.next();
                vehicle.setVehicleNumber(vehicleNumber);
                TicketService ticketService = new TicketService(
                        TicketRepository.getInstance(),
                        ParkingSpotRepository.getInstance(),
                        ParkingLotRepository.getInstance(),
                        GateRepository.getInstance()
                );
                TicketController ticketController = new TicketController(ticketService);

                Ticket ticket = ticketController.getTicket(parkingLotID,vehicle,gateId);
                System.out.println(ticket);

            } else if (choice==2) {

                BillService billService = new BillService(
                  ParkingLotRepository.getInstance(),
                  TicketRepository.getInstance(),
                  ParkingSpotRepository.getInstance()   ,
                  GateRepository.getInstance()
                );

                System.out.println("Enter the parking lot number");
                int parkingLotID = Integer.parseInt(sc.next());
                System.out.println("Enter the gate Id");
                int gateId = Integer.parseInt(sc.next());
                System.out.println("Enter the ticket ID");
                int ticketId = Integer.parseInt(sc.next());

                BillController billController = new BillController(billService);
                Bill generatedBill = billController.getBill(ticketId,parkingLotID,gateId);
                System.out.println(generatedBill);
                
                generatedBill.setBillStatus(BillStatus.PAID);
                break;
            }
        }


    }

    private static InitialisationService getInitialisationService(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository) {
        ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getInstance();
        GateRepository gateRepository = GateRepository.getInstance();
        return new InitialisationService(
                parkingLotRepository,
                parkingSpotRepository,
                parkingFloorRepository,
                gateRepository
        );
    }
}
