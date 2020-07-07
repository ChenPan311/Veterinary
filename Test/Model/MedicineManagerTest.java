package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicineManagerTest {
    MedicineManager medicineManager = MedicineManager.singletonMedicineManager("medicinesTest.dat");
    Medicine medicine = new Medicine("9","fsfdsfs","anti");

    @Test
    void findMedicineId() {
        medicineManager.addMedicine(medicine,10);
        assertTrue(medicineManager.findMedicineId("9"));
        assertFalse(medicineManager.findMedicineId("12"));
    }


}