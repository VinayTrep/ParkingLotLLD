package repositories;

import exceptions.ParkingFloorNotFoundException;
import models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepository {
    private final HashMap<Integer, ParkingFloor> parkingFloorHashMap;
    public static ParkingFloorRepository instance;
    private static int id = 0;

    private ParkingFloorRepository() {
        this.parkingFloorHashMap = new HashMap<>();
    }
    public static ParkingFloorRepository getInstance(){
        if (instance == null){
            instance = new ParkingFloorRepository();
        }
        return instance;
    }

    public void add(ParkingFloor parkingFloor){
        parkingFloor.setId(++id);
        parkingFloorHashMap.put(parkingFloor.getId(),parkingFloor);
    }

    public ParkingFloor getParkingFloor(int parkingFloorId){
        ParkingFloor parkingFloor = parkingFloorHashMap.get(parkingFloorId);

        if (parkingFloor == null){
            throw new ParkingFloorNotFoundException("The parkingFloor with parkingFloorId " + parkingFloorId + " does not exist");
        }
        return parkingFloor;
    }
}
