package Exceptions;

public class PersonNotExistException extends Exception {
    public PersonNotExistException(String message) {
        super(message);
    }
}
