package exceptions;

public class GateIDNotFoundException extends RuntimeException{
    public GateIDNotFoundException() {
    }

    public GateIDNotFoundException(String message) {
        super(message);
    }
}
