package Model;

import View.RegisterCustomerView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Customer extends Person {
    private int customerNumber;
    private ArrayList<Pet> petList;

    public Customer() {
        petList=new ArrayList<>();
    }

    public Customer(String name, String phoneNumber, String email, String address, String id) {
        super(name, phoneNumber, email, address, id);
        petList=new ArrayList<>();
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public ArrayList<Pet> getPetList() {
        return petList;
    }

    public void setPetList(ArrayList<Pet> petList) {
        this.petList = petList;
    }
    public void addPetToList(Pet pet){
        petList.add(pet);
    }
    public void removePetFromList(int index){
        petList.remove(index);
    }

    public boolean searchPetById(String id){
        for(Pet pet:petList) {
            if (pet.getPetId().equals(id))
                return true;
        }
        return false;
    }

    public Pet getPetFromList(int index){
        return petList.get(index);
    }
    // missing methods from class diagram


}
