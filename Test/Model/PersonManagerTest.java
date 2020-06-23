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
    void addPerson() throws PersonAlreadyExistException {
        personManager.addPerson(customer);
        assertEquals(1,personManager.getPersons().size());
        personManager.addPerson(customer1);
        assertEquals(2,personManager.getPersons().size());
    }

    @Test
    void removePerson() throws PersonNotExistException {
        personManager.removePerson(customer);
        assertEquals(1,personManager.getPersons().size());
    }

    @Test
    void searchById() {
        personManager.searchById(customer.getId());
    }

    @Test
    void searchPetForCustomer() {
        Dog dog = new Dog("1","a","22/11/12","Ye","male",32.2,"lab","Big",false,false);
        customer1.addPetToList(dog);
        personManager.searchPetForCustomer(customer1.getId(),dog.getPetId());
    }


    @Test
    void addPetToList() {
        assertEquals(1,customer1.getPetList().size());
    }

    @Test
    void removePetFromList() {
        customer1.removePetFromList(0);
    }


}