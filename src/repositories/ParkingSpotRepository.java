package repositories;

import exceptions.ParkingSpotNotFoundException;
import models.ParkingSpot;

import java.util.HashMap;

public class ParkingSpotRepository {
    private final HashMap<Integer, ParkingSpot> parkingSpotHashMap;
    public static ParkingSpotRepository instance;
    private static int id = 0;

    private ParkingSpotRepository() {
        this.parkingSpotHashMap = new HashMap<>();
    }

    public static ParkingSpotRepository getInstance() {
        if (instance == null) {
            instance = new ParkingSpotRepository();
        }
        return instance;
    }

    public void add(ParkingSpot parkingSpot) {
        if (parkingSpot.getId() == 0) {
            parkingSpot.setId(++id);
        }
        parkingSpotHashMap.put(parkingSpot.getId(), parkingSpot);
    }

    public ParkingSpot getParkingSpot(int parkingSpotId) {
        ParkingSpot parkingSpot = parkingSpotHashMap.get(parkingSpotId);

        if (parkingSpot == null) {
            throw new ParkingSpotNotFoundException("The parkingSpot with parkingSpotId " + parkingSpotId + " does not exist");
        }
        return parkingSpot;
    }
}
