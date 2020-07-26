package Controller;

import Model.*;
import Model.TablesModels.PersonTableModel;
import Model.TablesModels.PetTableModel;
import View.Dialogs.AddPetToCustomerDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class AddPetToCustomerController {
    private PersonManager model;
    private Customer customer;


    public AddPetToCustomerController(Customer customer) {
        this.model = PersonManager.singletonPersonManager("persons3");
        this.customer = customer;
    }

    public void addPetToCustomer(Pet pet) {
        model.addPetToList(customer, pet);
    }

    public void deletePetFromCustomer(int selectedRowIndex) {
        model.removePetFromList(customer, selectedRowIndex);
    }

    public void updatePetOfCustomer(Pet pet, int row) {
        model.updatePetFromList(customer, pet, row);
    }

    public Customer getCustomer() {
        return customer;
    }

    //    public boolean petIsExist(String customerId,String petId){
//        return model.searchPetForCustomer(customerId,petId);
//    }

}
