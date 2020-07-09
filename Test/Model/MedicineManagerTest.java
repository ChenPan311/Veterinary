package Model;

import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicineManagerTest {
    MedicineManager medicineManager;
    Medicine medicine = new Medicine("9","fsfdsfs","anti");

    @BeforeEach
    public void setUpMethod() {
        System.out.println("setUp");
        medicineManager = MedicineManager.singletonMedicineManager("medicinesTest.dat");
    }


    @Test
    void findMedicineId() {
        medicineManager.addMedicine(medicine,10);
        assertTrue(medicineManager.findMedicineId("9"));
        assertFalse(medicineManager.findMedicineId("12"));
    }

    @Test
    void removeMedicine()
    {
        medicineManager.addMedicine(medicine,10);
        medicineManager.removeMedicine(medicine);
        assertTrue(medicineManager.findMedicineId("9"));
    }

    @Test
    void decreaseQuantityFromMedicineStock()
    {
        medicineManager.removeMedicine(medicine);
        medicineManager.addMedicine(medicine,100);
        try {
            medicineManager.decreaseQuantityFromMedicineStock(medicine,10);
        } catch (MedicineNotExistException e) {
            e.printStackTrace();
        } catch (MedicineQuantityInsufficient medicineQuantityInsufficient) {
            medicineQuantityInsufficient.printStackTrace();
        }
        assertTrue(medicineManager.getMedicineQuantity(medicine)==90);
        assertFalse(medicineManager.getMedicineQuantity(medicine)==100);

        assertThrows(MedicineNotExistException.class,
                ()->{
                    medicineManager.decreaseQuantityFromMedicineStock(new Medicine("6","fsfdsfs","fds"),5);
                });
        assertThrows(MedicineQuantityInsufficient.class,
                ()->{
                    medicineManager.decreaseQuantityFromMedicineStock(new Medicine("9","fsfdsfs","fds"),100);
                });
    }




}