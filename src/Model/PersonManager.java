package Model;

import Model.*;
import View.AddPetToCustomerView;
import View.RegisterCustomerView;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PersonManager {
    private Random random = new Random();
    private ArrayList<Person> persons;

    public PersonManager() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
   /* public Vet getVet(Person person){
        for (Person p:persons){
            if(p instanceof Vet&&p.equals(person))
                return (Vet)p;

        }
    }*/

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Random getRandom() {
        return random;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public boolean searchById(String id){
        for(Person person:persons){
            if(person.getId().equals(id))
                return true;
        }
        return false;
    }

    public boolean searchPetForCustomer(String customerId,String petId){
        for(Person person:persons){
            if(person instanceof Customer && searchById(customerId))
                if(((Customer)person).searchPetById(petId))
                    return true;
        }
        return false;
    }
    // missing methods from class diagram
}
