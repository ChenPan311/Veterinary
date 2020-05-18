package Controller;

import Model.*;
import View.AddPetToCustomerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddPetToCustomerController {
    private AddPetToCustomerView view;
    private PersonManager model;

    public AddPetToCustomerController(PersonManager model, AddPetToCustomerView view) {
        this.view = view;
        this.model = model;
        view.addPetToCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isFound=false;
                if (view.validateFields()) {
                    for (Person person : model.getPersons()) {
                        if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Dog")) {
                            if (person.getId().equals(view.getDogPanel().getCustomerId_tf().getText())) {
                                Dog pet = new Dog();
                                pet.setOwnerId(view.getDogPanel().getCustomerId_tf().getText());
                                pet.setPetId(view.getDogPanel().getPetId_tf().getText());
                                pet.setName(view.getDogPanel().getName_tf().getText());
                                pet.setDateOfBirth(view.getDogPanel().getDateOfBirth_tf().getText());
                                pet.setColor(view.getDogPanel().getColor_tf().getText());
                                pet.setGender(view.getDogPanel().getMale().isSelected()?"Male":"Female");
                                pet.setWeight(Double.parseDouble(view.getDogPanel().getWeight_tf().getText()));
                                pet.setBreed(view.getDogPanel().getBreed_tf().getText());
                                pet.setSize(view.getDogPanel().getSize_tf().getText());
                                pet.setCastrated(view.getDogPanel().getYes_ic().isSelected());
                                pet.setGuidenceDog(view.getDogPanel().getYes_ig().isSelected());
                                ((Customer) person).addPetToList(pet);
                                System.out.println(pet);
                                JOptionPane.showMessageDialog(view, "Success");
                                isFound=true;
                                break;
                            }
                        } else if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Cat")) {
                            if (person.getId().equals(view.getCatPanel().getCustomerId_tf().getText())) {
                                Cat pet = new Cat();
                                pet.setOwnerId(view.getCatPanel().getCustomerId_tf().getText());
                                pet.setPetId(view.getCatPanel().getPetId_tf().getText());
                                pet.setName(view.getCatPanel().getName_tf().getText());
                                pet.setDateOfBirth(view.getCatPanel().getDateOfBirth_tf().getText());
                                pet.setColor(view.getCatPanel().getColor_tf().getText());
                                pet.setGender(view.getCatPanel().getMale().isSelected()?"Male":"Female");
                                pet.setWeight(Double.parseDouble(view.getCatPanel().getWeight_tf().getText()));
                                pet.setBreed(view.getCatPanel().getBreed_tf().getText());
                                pet.setCastrated(view.getCatPanel().getYes_ic().isSelected());
                                ((Customer) person).addPetToList(pet);
                                System.out.println(pet);
                                JOptionPane.showMessageDialog(view, "Success");
                                isFound=true;
                                break;
                            }
                        } else if (Objects.equals(view.getPetChooser_cb().getSelectedItem(), "Other")) {
                            if (person.getId().equals(view.getOtherPanel().getCustomerId_tf().getText())) {
                                Other pet = new Other();
                                pet.setOwnerId(view.getOtherPanel().getCustomerId_tf().getText());
                                pet.setPetId(view.getOtherPanel().getPetId_tf().getText());
                                pet.setName(view.getOtherPanel().getName_tf().getText());
                                pet.setDateOfBirth(view.getOtherPanel().getDateOfBirth_tf().getText());
                                pet.setColor(view.getOtherPanel().getColor_tf().getText());
                                pet.setGender(view.getOtherPanel().getMale().isSelected()?"Male" : "Female");
                                pet.setWeight(Double.parseDouble(view.getOtherPanel().getWeight_tf().getText()));
                                pet.setTypeOfPet(view.getOtherPanel().getTypeOfPet_tf().getText());
                                pet.setInfo(view.getOtherPanel().getInfo_tf().getText());
                                ((Customer) person).addPetToList(pet);
                                System.out.println(pet);
                                JOptionPane.showMessageDialog(view, "Success");
                                isFound=true;
                                break;
                            }
                        }

                    }
                    if(!isFound)
                        JOptionPane.showMessageDialog(view,"There Is No Customer With That Id!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            }


        }
    );
}
}
