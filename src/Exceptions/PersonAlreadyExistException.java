package Exceptions;

public class PersonAlreadyExistException extends Exception {
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
