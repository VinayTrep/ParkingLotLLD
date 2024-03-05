package services;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.*;
import repositories.GateRepository;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import services.Strategy.BillGenerationStrategy.BillGenerationStrategyFactory;
import services.Strategy.BillGenerationStrategy.BillGenerationStrategyType;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategyFactory;
import services.Strategy.SpotAllocationStrategy.SpotAllocationStrategyType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialisationService {

    private final ParkingLotRepository parkingLotRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingFloorRepository parkingFloorRepository;
    private final GateRepository gateRepository;

    public InitialisationService(ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository, ParkingFloorRepository parkingFloorRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.gateRepository = gateRepository;
    }

    public void init(){

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(100);
        parkingLot.setName("RMZ");
        parkingLot.setAddress("Yelahanka");
        parkingLot.setVehicalTypeSupported(Arrays.asList(VehicleType.EV, VehicleType.LUXE, VehicleType.CAR, VehicleType.BIKE));
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCreatedAt(LocalDateTime.now());
        parkingLot.setUpdatedAt(LocalDateTime.now());
        parkingLot.setCreatedBy("Initialization process");
        parkingLot.setUpdatedBy("Initialization process");
        parkingLot.setSpotAllocationStrategy(SpotAllocationStrategyFactory.getSpotAllocationStrategy(SpotAllocationStrategyType.LINEAR));
        parkingLot.setBillGenerationStrategy(BillGenerationStrategyFactory.getBillGenerationStrategy(BillGenerationStrategyType.SIMPLE));

        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {

            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.IN_USE);


            List<ParkingSpot> parkingSpotList = new ArrayList<>();
            for (int j = 1; j <=10; j++) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setSpotNumber(i*100+j);
                if (j<3){
                    parkingSpot.setVehicleType(VehicleType.LUXE);
                } else if (j<6) {
                    parkingSpot.setVehicleType(VehicleType.BIKE);
                } else if (j<9) {
                    parkingSpot.setVehicleType(VehicleType.CAR);
                }else {
                    parkingSpot.setVehicleType(VehicleType.EV);
                }

                parkingSpotList.add(parkingSpot);
                parkingSpotRepository.add(parkingSpot);
            }

            parkingFloor.setParkingSpotList(parkingSpotList);

            //Enter gate
            Gate entryGate = new Gate();
            entryGate.setId(i*1000+1);
            entryGate.setGateType(GateType.ENTRY_GATE);
            entryGate.setOperator("Siri"+i+1);
            entryGate.setGateNumber(Integer.parseInt(i+"01"));
            entryGate.setGateStatus(GateStatus.OPEN);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.add(entryGate);

            //Enter gate
            Gate exitGate = new Gate();
            exitGate.setId(i*1000+2);
            exitGate.setGateType(GateType.EXIT_GATE);
            exitGate.setOperator("Siri" + i+2);
            exitGate.setGateNumber(Integer.parseInt(i+"02"));
            exitGate.setGateStatus(GateStatus.OPEN);
            parkingFloor.setExitGate(exitGate);
            gateRepository.add(exitGate);

            parkingFloorRepository.add(parkingFloor);
            parkingFloorList.add(parkingFloor);
        }

        parkingLot.setParkingFloors(parkingFloorList);
        parkingLotRepository.add(parkingLot);
    }
}
