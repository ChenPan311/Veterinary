package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicineManagerTest {
    MedicineManager medicineManager = MedicineManager.singletonMedicineManager();

    @Test
    void findMedicineId() {
        assertTrue(medicineManager.findMedicineId("9"));
        assertFalse(medicineManager.findMedicineId("12"));
    }
}