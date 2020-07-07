package Model;

import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagerTest {
    PersonManager personManager = PersonManager.singletonPersonManager();
    Customer customer = new Customer("a", "020321", "fsds3", "Fsafasfa", "123");
    Customer customer1 = new Customer("a", "020321", "fsds3", "Fsafasfa", "1234");

    @Test
    void searchById() {

        assertTrue(personManager.searchById("315877563"));
        assertFalse(personManager.searchById("3333"));
    }

    @Test
    void searchPetForCustomer() {
        assertTrue(personManager.searchPetForCustomer("315877563","22"));
        assertFalse(personManager.searchPetForCustomer("315877563","13233"));
    }




}