package repositories;

import exceptions.GateNotFoundException;
import models.Gate;

import java.util.HashMap;

public class GateRepository {
    private final HashMap<Integer, Gate> gateHashMap;
    public static GateRepository instance;

    private GateRepository() {
        this.gateHashMap = new HashMap<>();
    }
    public static GateRepository getInstance(){
        if (instance == null){
            instance = new GateRepository();
        }
        return instance;
    }

    public void add(Gate gate){
        gateHashMap.put(gate.getId(),gate);
    }

    public Gate getGate(int gateId){
        Gate gate = gateHashMap.get(gateId);

        if (gate == null){
            throw new GateNotFoundException("The gate with gateId " + gateId + " does not exist");
        }
        return gate;
    }
}
