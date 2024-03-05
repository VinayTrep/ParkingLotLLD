package services.Strategy.SpotAllocationStrategy;

import exceptions.ParkingLotFullException;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import models.enums.ParkingSpotStatus;

import java.util.List;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocateSpot(ParkingLot parkingLot, Vehicle vehicle) {

        List<ParkingFloor> floors = parkingLot.getParkingFloors();

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getParkingSpotList()) {
                if (spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)){
                    if (spot.getVehicleType() == vehicle.getVehicleType()){
                        return spot;
                    }
                }
            }
        }

        throw new ParkingLotFullException("The parking lot is filled");
    }
}
