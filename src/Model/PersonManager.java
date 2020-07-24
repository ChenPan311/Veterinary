package Model;


import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PersonManager {
    private Random random = new Random();
    private Set<Person> persons;
    private static PersonManager personManager;
    private String fileName;
    private FileManager<Person> fileManager;

    private PersonManager(String fileName) {
        this.fileName=fileName;
        fileManager=new FileManager<>(fileName);
        persons =fileManager.readFromFile();
    }

    public static PersonManager singletonPersonManager(String fileName) {
        if (personManager == null)
            personManager = new PersonManager(fileName);
        return personManager;

    }

    private void writePersonToFile() {
       fileManager.writeToFile(persons);
    }

    public void addPerson(Person person) throws PersonAlreadyExistException {
        if (!persons.contains(person)) {
            persons.add(person);
            writePersonToFile();
        } else
            throw new PersonAlreadyExistException(person.toString() + " Already Exist ");
    }

    public void removePerson(Person person) throws PersonNotExistException {
        if (persons.contains(person)) {
            persons.remove(person);
            writePersonToFile();
        } else {
            throw new PersonNotExistException(person.toString() + " Not Exists");
        }
    }

    public Set<Person> getPersons() {
        return new HashSet<>(persons);
    }


    public ArrayList<Person> getArrayListPersons() {
        return new ArrayList<Person>(persons);
    }

    public Random getRandom() {
        return random;
    }

    public boolean searchById(String id) {
        for (Person person : persons) {
            if (person.getId().equals(id))
                return true;
        }
        return false;
    }

    public boolean searchPetForCustomer(String customerId, String petId) {
        for (Person person : persons) {
            if (person instanceof Customer && person.getId().equals(customerId)) {
                if (((Customer) person).searchPetById(petId))
                    return true;
            }
        }
        return false;
    }

    public Customer getCustomerByRowIndex(int row) {
        return (Customer) getArrayListPersons().get(row);
    }

    public Customer getCustomerById(String id){
        for(Person person:persons) {
            if (person.getId().equals(id))
                return (Customer) person;
        }
        return null;

    }

    public void addPetToList(Customer customer, Pet pet) {
        customer.addPetToList(pet);
        writePersonToFile();
    }

    public void removePetFromList(Customer customer, int petIndex) {
        customer.removePetFromList(petIndex);
        writePersonToFile();
    }

    public void updatePetFromList(Customer customer, Pet pet, int petIndex) {
        customer.updatePetFromList(pet,petIndex);
        writePersonToFile();
    }

    public void updatePerson(Customer customer) {
        for (Person person : persons) {
            if (person.getId().equals(customer.getId())) {
                person.setId(customer.getId());
                person.setName(customer.getName());
                person.setAddress(customer.getAddress());
                person.setPhoneNumber(customer.getPhoneNumber());
                person.setEmail(customer.getEmail());
                writePersonToFile();
                break;
            }
        }
    }

}
