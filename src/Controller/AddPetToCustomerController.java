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
    //private static AddPetToCustomerController controller;
    private AddPetToCustomerDialog view;
    private PersonManager model;
    private Customer customer;

//    public static AddPetToCustomerController getInstance(AddPetToCustomerDialog view){
//        if(controller==null){
//            controller=new AddPetToCustomerController(model,);
//        }
//    }

    public AddPetToCustomerController(AddPetToCustomerDialog view, Customer customer) {
        this.view = view;
        this.model = PersonManager.singletonPersonManager("persons3");
        this.customer=customer;
    }

    public void addPetToCustomer(){
        if (view.validateFields()) {
            if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Dog")) {
                if (customer.searchPetById(view.getDogPanel().getId())) {
                    JOptionPane.showMessageDialog(view, "Pet Already Exist!");
                } else {
                    Dog pet = new Dog();
                    pet.setPetId(view.getDogPanel().getId());
                    pet.setName(view.getDogPanel().getName());
                    pet.setDateOfBirth(view.getDogPanel().getDateOfBirth());
                    pet.setColor(view.getDogPanel().getColor());
                    pet.setGender(view.getDogPanel().getMale() ? "Male" : "Female");
                    pet.setWeight(Double.parseDouble(view.getDogPanel().getWeight()));
                    pet.setBreed(view.getDogPanel().getBreed());
                    pet.setSize(view.getDogPanel().getSizeOfPet());
                    pet.setCastrated(view.getDogPanel().getYesCast());
                    pet.setGuidenceDog(view.getDogPanel().getYesGuid());
                    model.addPetToList(customer,pet);
                    view.getTablePanel().refresh();

                    JOptionPane.showMessageDialog(view, "Success");
                }
            } else if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Cat")) {
                if (customer.searchPetById(view.getCatPanel().getId())) {
                    JOptionPane.showMessageDialog(view, "Pet Already Exist!");
                } else {
                    Cat pet = new Cat();
                    pet.setPetId(view.getCatPanel().getId());
                    pet.setName(view.getCatPanel().getName());
                    pet.setDateOfBirth(view.getCatPanel().getDateOfBirth());
                    pet.setColor(view.getCatPanel().getColor());
                    pet.setGender(view.getCatPanel().getMale() ? "Male" : "Female");
                    pet.setWeight(Double.parseDouble(view.getCatPanel().getWeight()));
                    pet.setBreed(view.getCatPanel().getBreed());
                    pet.setCastrated(view.getCatPanel().getYesCast());
                    model.addPetToList(customer,pet);
                    view.getTablePanel().refresh();
                    JOptionPane.showMessageDialog(view, "Success");
                }
            } else if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Other")) {
                if (customer.searchPetById(view.getOtherPanel().getId())) {
                    JOptionPane.showMessageDialog(view, "Pet Already Exist!");
                } else {
                    Other pet = new Other();
                    pet.setPetId(view.getOtherPanel().getId());
                    pet.setName(view.getOtherPanel().getName());
                    pet.setDateOfBirth(view.getOtherPanel().getDateOfBirth());
                    pet.setColor(view.getOtherPanel().getColor());
                    pet.setGender(view.getOtherPanel().getMale()? "Male" : "Female");
                    pet.setWeight(Double.parseDouble(view.getOtherPanel().getWeight()));
                    pet.setTypeOfPet(view.getOtherPanel().getTypeOfPet());
                    pet.setInfo(view.getOtherPanel().getInfo());
                    model.addPetToList(customer,pet);
                    view.getTablePanel().refresh();
                    JOptionPane.showMessageDialog(view, "Success");
                }
            }

        } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
    }

    public void deletePetFromCustomer(){
        int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
        if (selectedRowIndex != -1) {
            model.removePetFromList(customer,selectedRowIndex);
            view.getTablePanel().refresh();
        }
    }

    public void updatePetOfCustomer(){
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            Pet pet = customer.getPetFromList(row);
            if (pet instanceof Dog) {
                if (view.validateFields()) {
                    pet.setPetId(view.getDogPanel().getId());
                    pet.setName(view.getDogPanel().getName());
                    pet.setDateOfBirth(view.getDogPanel().getDateOfBirth());
                    pet.setColor(view.getDogPanel().getColor());
                    pet.setGender(view.getDogPanel().getMale() ? "Male" : "Female");
                    pet.setWeight(Double.parseDouble(view.getDogPanel().getWeight()));
                    ((Dog) pet).setBreed(view.getDogPanel().getBreed());
                    ((Dog) pet).setSize(view.getDogPanel().getSizeOfPet());
                    ((Dog) pet).setCastrated(view.getDogPanel().getYesCast());
                    ((Dog) pet).setGuidenceDog(view.getDogPanel().getYesGuid());
                    model.updatePetFromList(customer,pet,row);
                    view.getTablePanel().refresh();
                    JOptionPane.showMessageDialog(view, "Updated!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");

            } else if (pet instanceof Cat) {
                if (view.validateFields()) {
                    pet.setPetId(view.getCatPanel().getId());
                    pet.setName(view.getCatPanel().getName());
                    pet.setDateOfBirth(view.getCatPanel().getDateOfBirth());
                    pet.setColor(view.getCatPanel().getColor());
                    pet.setGender(view.getCatPanel().getMale() ? "Male" : "Female");
                    pet.setWeight(Double.parseDouble(view.getCatPanel().getWeight()));
                    ((Cat) pet).setBreed(view.getCatPanel().getBreed());
                    ((Cat) pet).setCastrated(view.getCatPanel().getYesCast());
                    model.updatePetFromList(customer,pet,row);
                    view.getTablePanel().refresh();
                    JOptionPane.showMessageDialog(view, "Updated!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            } else if (pet instanceof Other) {
                if (view.validateFields()) {
                    pet.setPetId(view.getOtherPanel().getId());
                    pet.setName(view.getOtherPanel().getName());
                    pet.setDateOfBirth(view.getOtherPanel().getDateOfBirth());
                    pet.setColor(view.getOtherPanel().getColor());
                    pet.setGender(view.getOtherPanel().getMale() ? "Male" : "Female");
                    pet.setWeight(Double.parseDouble(view.getOtherPanel().getWeight()));
                    ((Other) pet).setTypeOfPet(view.getOtherPanel().getTypeOfPet());
                    ((Other) pet).setInfo(view.getOtherPanel().getInfo());
                    model.updatePetFromList(customer,pet,row);
                    view.getTablePanel().refresh();
                    JOptionPane.showMessageDialog(view, "Updated!");
                }
            } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
        } else JOptionPane.showMessageDialog(view, "Choose Pet First!");
    }

    public void addSelectedRow(){
        PetTableModel petmodel = (PetTableModel) view.getTablePanel().getTable().getModel();
        int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
        Pet pet = customer.getPetFromList(selectedRowIndex);
        if (pet instanceof Dog) {
            view.getPetChooser_cb().setSelectedItem("Dog");
            view.getDogPanel().setId(pet.getPetId());
            view.getDogPanel().setName(pet.getName());
            view.getDogPanel().setDateOfBirth(pet.getDateOfBirth());
            view.getDogPanel().setColor(pet.getColor());
            if (pet.getGender() == "Male") {
                view.getDogPanel().setMale(true);
            } else {
                view.getDogPanel().setFemale(true);
            }
            view.getDogPanel().setWeight(String.valueOf(pet.getWeight()));
            view.getDogPanel().setBreed(((Dog) pet).getBreed());
            view.getDogPanel().setSizeOfPet(((Dog) pet).getSize());
            if (((Dog) pet).getCastrated())
                view.getDogPanel().setYesCast(true);
            else view.getDogPanel().setNoCast(true);
            if (((Dog) pet).getGuidenceDog())
                view.getDogPanel().setYesGuid(true);
            else view.getDogPanel().setNoGuid(true);

        }
        if (pet instanceof Cat) {
            view.getPetChooser_cb().setSelectedItem("Cat");
            view.getCatPanel().setId(pet.getPetId());
            view.getCatPanel().setName(pet.getName());
            view.getCatPanel().setDateOfBirth(pet.getDateOfBirth());
            view.getCatPanel().setColor(pet.getColor());
            if (pet.getGender() == "Male") {
                view.getCatPanel().setMale(true);
            } else {
                view.getCatPanel().setFemale(true);
            }
            view.getCatPanel().setWeight(String.valueOf(pet.getWeight()));
            view.getCatPanel().setBreed(((Cat) pet).getBreed());
            if (((Cat) pet).getCastrated())
                view.getCatPanel().setYesCast(true);
            else view.getCatPanel().setNoCast(true);
        }
        if (pet instanceof Other) {
            view.getPetChooser_cb().setSelectedItem("Other");
            view.getOtherPanel().setId(pet.getPetId());
            view.getOtherPanel().setName(pet.getName());
            view.getOtherPanel().setDateOfBirth(pet.getDateOfBirth());
            view.getOtherPanel().setColor(pet.getColor());
            if (pet.getGender() == "Male") {
                view.getOtherPanel().setMale(true);
            } else {
                view.getOtherPanel().setFemale(true);
            }
            view.getOtherPanel().setWeight(String.valueOf(pet.getWeight()));
            view.getOtherPanel().setTypeOfPet(((Other) pet).getTypeOfPet());
            view.getOtherPanel().setInfo(((Other) pet).getInfo());
        }
    }


}
