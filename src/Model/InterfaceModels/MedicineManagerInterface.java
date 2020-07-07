package Model.InterfaceModels;

import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import Model.Medicine;

import java.util.List;

public interface MedicineManagerInterface {
    public void addMedicine(Medicine medicine, int quantity);
    public void decreaseQuantityFromMedicineStock(Medicine medicine,int quantity) throws MedicineNotExistException, MedicineQuantityInsufficient;
    public int getMedicineQuantity(Medicine medicine);
    public List<Medicine> getMedicineList();
    public List<Integer> getQuantityList();
}
