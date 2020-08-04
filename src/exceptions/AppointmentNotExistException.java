package exceptions;

public class AppointmentNotExistException extends Exception {

    public AppointmentNotExistException(String message) {
        super(message);
    }
}
