package exceptions;

public class ParkingLotFullException extends RuntimeException{
    public ParkingLotFullException() {
    }

    public ParkingLotFullException(String message) {
        super(message);
    }
}
