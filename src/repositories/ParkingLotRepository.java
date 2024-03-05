package repositories;

import exceptions.ParkingLotNotFoundException;
import models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    private final HashMap<Integer, ParkingLot> parkingLotHashMap;
    public static ParkingLotRepository instance;
    private static int id = 0;

    private ParkingLotRepository() {
        this.parkingLotHashMap = new HashMap<>();
    }
    public static ParkingLotRepository getInstance(){
        if (instance == null){
            instance = new ParkingLotRepository();
        }
        return instance;
    }

    public void add(ParkingLot parkingLot){
        parkingLot.setId(++id);
        parkingLotHashMap.put(parkingLot.getId(),parkingLot);
    }

    public ParkingLot getParkingLot(int parkingLotId){
        ParkingLot parkingLot = parkingLotHashMap.get(parkingLotId);

        if (parkingLot == null){
            throw new ParkingLotNotFoundException("The parkingLot with parkingLotId " + parkingLotId + " does not exist");
        }
        return parkingLot;
    }
}
