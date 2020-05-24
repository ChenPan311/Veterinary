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
    private AddPetToCustomerDialog view;
    private PersonManager model;

    public AddPetToCustomerController(PersonManager model, AddPetToCustomerDialog view, Customer customer) {
        this.view = view;
        this.model = model;
        view.addPetToCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Dog")) {
                        if (customer.searchPetById(view.getDogPanel().getPetId_tf().getText())) {
                            JOptionPane.showMessageDialog(view, "Pet Already Exist!");
                        } else {
                            Dog pet = new Dog();
                            pet.setPetId(view.getDogPanel().getPetId_tf().getText());
                            pet.setName(view.getDogPanel().getName_tf().getText());
                            pet.setDateOfBirth(view.getDogPanel().getDateOfBirth_tf().getText());
                            pet.setColor(view.getDogPanel().getColor_tf().getText());
                            pet.setGender(view.getDogPanel().getMale().isSelected() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(view.getDogPanel().getWeight_tf().getText()));
                            pet.setBreed(view.getDogPanel().getBreed_tf().getText());
                            pet.setSize(view.getDogPanel().getSize_tf().getText());
                            pet.setCastrated(view.getDogPanel().getYes_ic().isSelected());
                            pet.setGuidenceDog(view.getDogPanel().getYes_ig().isSelected());
                            model.addPetToList(customer,pet);
                            view.getTablePanel().refresh();

                            JOptionPane.showMessageDialog(view, "Success");
                        }
                    } else if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Cat")) {
                        if (customer.searchPetById(view.getCatPanel().getPetId_tf().getText())) {
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
                        if (customer.searchPetById(view.getOtherPanel().getPetId_tf().getText())) {
                            JOptionPane.showMessageDialog(view, "Pet Already Exist!");
                        } else {
                            Other pet = new Other();
                            pet.setPetId(view.getOtherPanel().getPetId_tf().getText());
                            pet.setName(view.getOtherPanel().getName_tf().getText());
                            pet.setDateOfBirth(view.getOtherPanel().getDateOfBirth_tf().getText());
                            pet.setColor(view.getOtherPanel().getColor_tf().getText());
                            pet.setGender(view.getOtherPanel().getMale().isSelected() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(view.getOtherPanel().getWeight_tf().getText()));
                            pet.setTypeOfPet(view.getOtherPanel().getTypeOfPet_tf().getText());
                            pet.setInfo(view.getOtherPanel().getInfo_tf().getText());
                            model.addPetToList(customer,pet);
                            view.getTablePanel().refresh();
                            JOptionPane.showMessageDialog(view, "Success");
                        }
                    }

                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            }
        });

        view.deletePetFromCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                if (selectedRowIndex != -1) {
                    model.removePetFromList(customer,selectedRowIndex);
                    view.getTablePanel().refresh();
                }
            }
        });

        view.updatePetOfCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    Pet pet = customer.getPetFromList(row);
                    if (pet instanceof Dog) {
                        if (view.validateFields()) {
                            pet.setPetId(view.getDogPanel().getPetId_tf().getText());
                            pet.setName(view.getDogPanel().getName_tf().getText());
                            pet.setDateOfBirth(view.getDogPanel().getDateOfBirth_tf().getText());
                            pet.setColor(view.getDogPanel().getColor_tf().getText());
                            pet.setGender(view.getDogPanel().getMale().isSelected() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(view.getDogPanel().getWeight_tf().getText()));
                            ((Dog) pet).setBreed(view.getDogPanel().getBreed_tf().getText());
                            ((Dog) pet).setSize(view.getDogPanel().getSize_tf().getText());
                            ((Dog) pet).setCastrated(view.getDogPanel().getYes_ic().isSelected());
                            ((Dog) pet).setGuidenceDog(view.getDogPanel().getYes_ig().isSelected());
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
                            view.getTablePanel().refresh();
                            JOptionPane.showMessageDialog(view, "Updated!");
                        } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                    } else if (pet instanceof Other) {
                        if (view.validateFields()) {
                            pet.setPetId(view.getOtherPanel().getPetId_tf().getText());
                            pet.setName(view.getOtherPanel().getName_tf().getText());
                            pet.setDateOfBirth(view.getOtherPanel().getDateOfBirth_tf().getText());
                            pet.setColor(view.getOtherPanel().getColor_tf().getText());
                            pet.setGender(view.getOtherPanel().getMale().isSelected() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(view.getOtherPanel().getWeight_tf().getText()));
                            ((Other) pet).setTypeOfPet(view.getOtherPanel().getTypeOfPet_tf().getText());
                            ((Other) pet).setInfo(view.getOtherPanel().getInfo_tf().getText());
                            view.getTablePanel().refresh();
                            JOptionPane.showMessageDialog(view, "Updated!");
                        }
                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                } else JOptionPane.showMessageDialog(view, "Choose Pet First!");
            }
        });

        view.getTablePanel().addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PetTableModel petmodel = (PetTableModel) view.getTablePanel().getTable().getModel();
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                Pet pet = customer.getPetFromList(selectedRowIndex);
                if (pet instanceof Dog) {
                    view.getPetChooser_cb().setSelectedItem("Dog");
                    view.getDogPanel().getPetId_tf().setText(pet.getPetId());
                    view.getDogPanel().getName_tf().setText(pet.getName());
                    view.getDogPanel().getDateOfBirth_tf().setText(pet.getDateOfBirth());
                    view.getDogPanel().getColor_tf().setText(pet.getColor());
                    if (pet.getGender() == "Male") {
                        view.getDogPanel().getMale().setSelected(true);
                    } else {
                        view.getDogPanel().getFemale().setSelected(true);
                    }
                    view.getDogPanel().getWeight_tf().setText(String.valueOf(pet.getWeight()));
                    view.getDogPanel().getBreed_tf().setText(((Dog) pet).getBreed());
                    view.getDogPanel().getSize_tf().setText(((Dog) pet).getSize());
                    if (((Dog) pet).getCastrated())
                        view.getDogPanel().getYes_ic().setSelected(true);
                    else view.getDogPanel().getNo_ic().setSelected(true);
                    if (((Dog) pet).getGuidenceDog())
                        view.getDogPanel().getYes_ig().setSelected(true);
                    else view.getDogPanel().getNo_ig().setSelected(true);

                }
                if (pet instanceof Cat) {
                    view.getPetChooser_cb().setSelectedItem("Cat");
                    view.getCatPanel().getPetId_tf().setText(pet.getPetId());
                    view.getCatPanel().getName_tf().setText(pet.getName());
                    view.getCatPanel().getDateOfBirth_tf().setText(pet.getDateOfBirth());
                    view.getCatPanel().getColor_tf().setText(pet.getColor());
                    if (pet.getGender() == "Male") {
                        view.getCatPanel().getMale_rb().setSelected(true);
                    } else {
                        view.getCatPanel().getFemale_rb().setSelected(true);
                    }
                    view.getCatPanel().getWeight_tf().setText(String.valueOf(pet.getWeight()));
                    view.getCatPanel().getBreed_tf().setText(((Cat) pet).getBreed());
                    if (((Cat) pet).getCastrated())
                        view.getCatPanel().getYes_ic().setSelected(true);
                    else view.getCatPanel().getNo_ic().setSelected(true);
                }
                if (pet instanceof Other) {
                    view.getPetChooser_cb().setSelectedItem("Other");
                    view.getOtherPanel().getPetId_tf().setText(pet.getPetId());
                    view.getOtherPanel().getName_tf().setText(pet.getName());
                    view.getOtherPanel().getDateOfBirth_tf().setText(pet.getDateOfBirth());
                    view.getOtherPanel().getColor_tf().setText(pet.getColor());
                    if (pet.getGender() == "Male") {
                        view.getOtherPanel().getMale().setSelected(true);
                    } else {
                        view.getOtherPanel().getFemale().setSelected(true);
                    }
                    view.getOtherPanel().getWeight_tf().setText(String.valueOf(pet.getWeight()));
                    view.getOtherPanel().getTypeOfPet_tf().setText(((Other) pet).getTypeOfPet());
                    view.getOtherPanel().getInfo_tf().setText(((Other) pet).getInfo());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
