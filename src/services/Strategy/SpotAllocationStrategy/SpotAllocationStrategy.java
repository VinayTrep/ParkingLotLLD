package services.Strategy.SpotAllocationStrategy;

import models.ParkingLot;
import models.ParkingSpot;
import models.Vehical;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(ParkingLot parkingLot, Vehical vehical);
}
