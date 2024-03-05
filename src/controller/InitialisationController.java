package controller;


import models.ParkingLot;
import services.InitialisationService;

public class InitialisationController {
    private final InitialisationService initialisationService;

    public InitialisationController(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }

    public void init(){
         initialisationService.init();
    }

}
