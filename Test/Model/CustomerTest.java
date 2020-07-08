package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    Customer customer = new Customer("me","3423","mail","home","231");
    Other pet = new Other("123","animal","d","d","D",342,"fs","sd");
    Other pet2 = new Other("32","ds","d","SD","ds",32,"s","s");

    @Test
    void searchPetById()
    {
        customer.addPetToList(pet);
        assertTrue(customer.searchPetById(pet.getPetId()));
        assertFalse(customer.searchPetById(pet2.getPetId()));
    }

    @Test
    void removePetFromList()
    {
        customer.addPetToList(pet);
        customer.removePetFromList(0);
        assertFalse(customer.searchPetById(pet.getPetId()));
    }
}
