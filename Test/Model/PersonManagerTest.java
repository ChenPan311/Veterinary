package Model;

import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagerTest {

    PersonManager personManager;
    Customer customer = new Customer("a", "020321", "fsds3", "Fsafasfa", "123");
    Customer customer2 = new Customer("b", "020321", "fsds3", "Fsafasfa", "12345");

    Cat cat = new Cat("1234","mizi","today","blue","male",30,"cat",false);
    Dog dog = new Dog();

    @BeforeEach
    public void setUpMethod() {
        System.out.println("setUp");
        personManager = PersonManager.singletonPersonManager("personTest.dat").singletonPersonManager("medicinesTest.dat");
    }

    @Test
    void searchById() {
        try {
            personManager.addPerson(customer);
        } catch (PersonAlreadyExistException e) {

        }
        assertTrue(personManager.searchById(customer.getId()));
        assertFalse(personManager.searchById(customer2.getId()));

        assertThrows(PersonAlreadyExistException.class,
                ()->{
                    personManager.addPerson(customer);
                });

    }

    @Test
    void updatePerson()
    {
        try {
            personManager.addPerson(customer);
        } catch (PersonAlreadyExistException e) {

        }
        assertThrows(PersonAlreadyExistException.class,
                ()->{
                    personManager.addPerson(customer);
                });
        customer.setEmail("new");
        personManager.updatePerson(customer);
        assertTrue(personManager.getCustomerById(customer.getId()).getEmail().equals("new"));
    }

  


*//*        assertTrue(personManager.searchPetForCustomer("315877563","22"));
        assertFalse(personManager.searchPetForCustomer("315877563","13233"));*//*
    }*/




}