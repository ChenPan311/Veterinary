package View.Dialogs;

import Controller.AddPetToCustomerController;
import Model.*;
import Model.TablesModels.PetTableModel;
import View.Panels.CatPanel;
import View.Panels.DogPanel;
import View.Panels.OtherPanel;
import View.Panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class AddPetToCustomerDialog extends JDialog {
    private JComboBox<String> petChooser_cb;
    private JButton addBtn, deleteBtn, updateBtn;
    private JPanel petPanel, comboBoxPetPanel, addPetPanel;
    private TablePanel tablePanel;
    private DogPanel dogPanel;
    private CatPanel catPanel;
    private OtherPanel otherPanel;
    final static String DOG_PANEL = "Dog";
    final static String CAT_PANEL = "Cat";
    final static String OTHER_PANEL = "Other";
    private AddPetToCustomerController controller;

    public AddPetToCustomerDialog(Customer customer) {
        create(customer);
        setBackground(Color.ORANGE);
        this.setVisible(true);
    }

    private void create(Customer customer) {

        String[] petOptions = {DOG_PANEL, CAT_PANEL, OTHER_PANEL};
        petChooser_cb = new JComboBox<String>(petOptions);
        petChooser_cb.setEditable(false);
        comboBoxPetPanel = new JPanel();
        comboBoxPetPanel.add(petChooser_cb);


        addPetPanel = new JPanel();
        addBtn = new JButton("Add");
        deleteBtn = new JButton("Delete");
        updateBtn = new JButton("Update");
        addPetPanel.add(addBtn);
        addPetPanel.add(deleteBtn);
        addPetPanel.add(updateBtn);

        dogPanel = new DogPanel();
        catPanel = new CatPanel();
        otherPanel = new OtherPanel();
        tablePanel = new TablePanel(new PetTableModel());

        petPanel = new JPanel(new CardLayout());
        petPanel.add(dogPanel, DOG_PANEL);
        petPanel.add(catPanel, CAT_PANEL);
        petPanel.add(otherPanel, OTHER_PANEL);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);

        gbc.ipady = 120;
        gbc.ipadx = 3;
        gbc.weightx = 4;
        gbc.weighty = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(tablePanel, gbc);

        gbc.ipady = 0;
        gbc.ipadx = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 1;
        add(comboBoxPetPanel, gbc);

        gbc.gridy = 2;
        add(petPanel, gbc);

        gbc.gridy = 3;
        add(addPetPanel, gbc);


        petChooser_cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout) (petPanel.getLayout());
                cl.show(petPanel, (String) e.getItem());
            }
        });

        setSize(new Dimension(900, 600));
        this.setTitle("Add Pet To Customer");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        controller = new AddPetToCustomerController(customer);
        addPetToCustomer(customer);
        deletePetFromCustomer();
        updatePet(customer);
        selectedRow(customer);
    }

    public JComboBox<String> getPetChooser_cb() {
        return petChooser_cb;
    }

    public void setPetChooser_cb(JComboBox<String> petChooser_cb) {
        this.petChooser_cb = petChooser_cb;
    }

    public JPanel getAddPetPanel() {
        return addPetPanel;
    }

    public JPanel getComboBoxPetPanel() {
        return comboBoxPetPanel;
    }

    public DogPanel getDogPanel() {
        return dogPanel;
    }

    public CatPanel getCatPanel() {
        return catPanel;
    }

    public OtherPanel getOtherPanel() {
        return otherPanel;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }


    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public void addPetToCustomer(Customer customer) {
        getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    if (Objects.equals(getPetChooser_cb().getSelectedItem(), "Dog")) {
                        if (customer.searchPetById(getDogPanel().getId())) {
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Pet Already Exist!");
                        } else {
                            Dog pet = new Dog();
                            pet.setPetId(getDogPanel().getId());
                            pet.setName(getDogPanel().getName());
                            pet.setDateOfBirth(getDogPanel().getDateOfBirth());
                            pet.setColor(getDogPanel().getColor());
                            pet.setGender(getDogPanel().getMale() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(getDogPanel().getWeight()));
                            pet.setBreed(getDogPanel().getBreed());
                            pet.setSize(getDogPanel().getSizeOfPet());
                            pet.setCastrated(getDogPanel().getYesCast());
                            pet.setGuidenceDog(getDogPanel().getYesGuid());
                            controller.addPetToCustomer(pet);
                            getTablePanel().refresh();
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Success");
                        }
                    } else if (Objects.equals(getPetChooser_cb().getSelectedItem(), "Cat")) {
                        if (customer.searchPetById(getCatPanel().getId())) {
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Pet Already Exist!");
                        } else {
                            Cat pet = new Cat();
                            pet.setPetId(getCatPanel().getId());
                            pet.setName(getCatPanel().getName());
                            pet.setDateOfBirth(getCatPanel().getDateOfBirth());
                            pet.setColor(getCatPanel().getColor());
                            pet.setGender(getCatPanel().getMale() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(getCatPanel().getWeight()));
                            pet.setBreed(getCatPanel().getBreed());
                            pet.setCastrated(getCatPanel().getYesCast());
                            controller.addPetToCustomer(pet);
                            getTablePanel().refresh();
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Success");
                        }
                    } else if (Objects.equals(getPetChooser_cb().getSelectedItem(), "Other")) {
                        if (customer.searchPetById(getOtherPanel().getId())) {
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Pet Already Exist!");
                        } else {
                            Other pet = new Other();
                            pet.setPetId(getOtherPanel().getId());
                            pet.setName(getOtherPanel().getName());
                            pet.setDateOfBirth(getOtherPanel().getDateOfBirth());
                            pet.setColor(getOtherPanel().getColor());
                            pet.setGender(getOtherPanel().getMale() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(getOtherPanel().getWeight()));
                            pet.setTypeOfPet(getOtherPanel().getTypeOfPet());
                            pet.setInfo(getOtherPanel().getInfo());
                            controller.addPetToCustomer(pet);
                            getTablePanel().refresh();
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Success");
                        }
                    }

                } else JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Fill All Fields!");

            }
        });
    }

    public void deletePetFromCustomer() {
        getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = getTablePanel().getTable().getSelectedRow();
                if (selectedRowIndex != -1) {
                    controller.deletePetFromCustomer(selectedRowIndex);
                    getTablePanel().refresh();
                }
            }
        });
    }

    public void updatePet(Customer customer) {
        getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = getTablePanel().getTable().getSelectedRow();
                    Pet pet = customer.getPetFromList(row);
                    if (pet instanceof Dog) {
                        if (validateFields()) {
                            pet.setPetId(getDogPanel().getId());
                            pet.setName(getDogPanel().getName());
                            pet.setDateOfBirth(getDogPanel().getDateOfBirth());
                            pet.setColor(getDogPanel().getColor());
                            pet.setGender(getDogPanel().getMale() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(getDogPanel().getWeight()));
                            ((Dog) pet).setBreed(getDogPanel().getBreed());
                            ((Dog) pet).setSize(getDogPanel().getSizeOfPet());
                            ((Dog) pet).setCastrated(getDogPanel().getYesCast());
                            ((Dog) pet).setGuidenceDog(getDogPanel().getYesGuid());
                            controller.updatePetOfCustomer(pet, row);
                            getTablePanel().refresh();
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Updated!");
                        } else JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Fill All Fields!");

                    } else if (pet instanceof Cat) {
                        if (validateFields()) {
                            pet.setPetId(getCatPanel().getId());
                            pet.setName(getCatPanel().getName());
                            pet.setDateOfBirth(getCatPanel().getDateOfBirth());
                            pet.setColor(getCatPanel().getColor());
                            pet.setGender(getCatPanel().getMale() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(getCatPanel().getWeight()));
                            ((Cat) pet).setBreed(getCatPanel().getBreed());
                            ((Cat) pet).setCastrated(getCatPanel().getYesCast());
                            controller.updatePetOfCustomer(pet, row);
                            getTablePanel().refresh();
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Updated!");
                        } else JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Fill All Fields!");
                    } else if (pet instanceof Other) {
                        if (validateFields()) {
                            pet.setPetId(getOtherPanel().getId());
                            pet.setName(getOtherPanel().getName());
                            pet.setDateOfBirth(getOtherPanel().getDateOfBirth());
                            pet.setColor(getOtherPanel().getColor());
                            pet.setGender(getOtherPanel().getMale() ? "Male" : "Female");
                            pet.setWeight(Double.parseDouble(getOtherPanel().getWeight()));
                            ((Other) pet).setTypeOfPet(getOtherPanel().getTypeOfPet());
                            ((Other) pet).setInfo(getOtherPanel().getInfo());
                            controller.updatePetOfCustomer(pet, row);
                            getTablePanel().refresh();
                            JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Updated!");
                        }
                    } else JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Fill All Fields!");
                } else JOptionPane.showMessageDialog(AddPetToCustomerDialog.this, "Choose Pet First!");
            }
        });
    }

    public void selectedRow(Customer customer) {
        getTablePanel().addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PetTableModel petmodel = (PetTableModel) getTablePanel().getTable().getModel();
                int selectedRowIndex = getTablePanel().getTable().getSelectedRow();
                Pet pet = customer.getPetFromList(selectedRowIndex);
                if (pet instanceof Dog) {
                    getPetChooser_cb().setSelectedItem("Dog");
                    getDogPanel().setId(pet.getPetId());
                    getDogPanel().setName(pet.getName());
                    getDogPanel().setDateOfBirth(pet.getDateOfBirth());
                    getDogPanel().setColor(pet.getColor());
                    if (pet.getGender() == "Male") {
                        getDogPanel().setMale(true);
                    } else {
                        getDogPanel().setFemale(true);
                    }
                    getDogPanel().setWeight(String.valueOf(pet.getWeight()));
                    getDogPanel().setBreed(((Dog) pet).getBreed());
                    getDogPanel().setSizeOfPet(((Dog) pet).getSize());
                    if (((Dog) pet).getCastrated())
                        getDogPanel().setYesCast(true);
                    else getDogPanel().setNoCast(true);
                    if (((Dog) pet).getGuidenceDog())
                        getDogPanel().setYesGuid(true);
                    else getDogPanel().setNoGuid(true);

                }
                if (pet instanceof Cat) {
                    getPetChooser_cb().setSelectedItem("Cat");
                    getCatPanel().setId(pet.getPetId());
                    getCatPanel().setName(pet.getName());
                    getCatPanel().setDateOfBirth(pet.getDateOfBirth());
                    getCatPanel().setColor(pet.getColor());
                    if (pet.getGender() == "Male") {
                        getCatPanel().setMale(true);
                    } else {
                        getCatPanel().setFemale(true);
                    }
                    getCatPanel().setWeight(String.valueOf(pet.getWeight()));
                    getCatPanel().setBreed(((Cat) pet).getBreed());
                    if (((Cat) pet).getCastrated())
                        getCatPanel().setYesCast(true);
                    else getCatPanel().setNoCast(true);
                }
                if (pet instanceof Other) {
                    getPetChooser_cb().setSelectedItem("Other");
                    getOtherPanel().setId(pet.getPetId());
                    getOtherPanel().setName(pet.getName());
                    getOtherPanel().setDateOfBirth(pet.getDateOfBirth());
                    getOtherPanel().setColor(pet.getColor());
                    if (pet.getGender() == "Male") {
                        getOtherPanel().setMale(true);
                    } else {
                        getOtherPanel().setFemale(true);
                    }
                    getOtherPanel().setWeight(String.valueOf(pet.getWeight()));
                    getOtherPanel().setTypeOfPet(((Other) pet).getTypeOfPet());
                    getOtherPanel().setInfo(((Other) pet).getInfo());
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

    public Boolean validateFields() {
        String string = (String) petChooser_cb.getSelectedItem();
        if (string.equals("Dog")) {
            return !(dogPanel.getId().equals("") ||
                    dogPanel.getName().equals("") ||
                    dogPanel.getDateOfBirth().equals("") ||
                    dogPanel.getColor().equals("") ||
                    dogPanel.getWeight().equals("") ||
                    dogPanel.getBreed().equals("") ||
                    dogPanel.getSizeOfPet().equals("") ||
                    dogPanel.isSelected());
        } else if (string.equals("Cat")) {
            return !(catPanel.getId().equals("") ||
                    catPanel.getName().equals("") ||
                    catPanel.getDateOfBirth().equals("") ||
                    catPanel.getColor().equals("") ||
                    catPanel.getWeight().equals("") ||
                    catPanel.getBreed().equals("") ||
                    catPanel.isSelected());
        } else if (string.equals("Other")) {
            return !(otherPanel.getId().equals("") ||
                    otherPanel.getName().equals("") ||
                    otherPanel.getDateOfBirth().equals("") ||
                    otherPanel.getColor().equals("") ||
                    otherPanel.getWeight().equals("") ||
                    otherPanel.getTypeOfPet().equals("") ||
                    otherPanel.getInfo().equals("") ||
                    otherPanel.isSelected());

        }
        return false;

    }


}
