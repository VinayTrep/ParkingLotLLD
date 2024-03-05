package services.Strategy.SpotAllocationStrategy;

import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(ParkingLot parkingLot, Vehicle vehical);
}
