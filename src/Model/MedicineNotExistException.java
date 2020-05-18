package Model;

public class MedicineNotExistException extends Exception {
    public MedicineNotExistException(String message) {
        super(message);
    }
}
