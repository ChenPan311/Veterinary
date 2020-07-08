package View.Dialogs;

import Controller.AddPetToCustomerController;
import Model.Customer;
import Model.Pet;
import Model.TablesModels.PetTableModel;
import View.Panels.CatPanel;
import View.Panels.DogPanel;
import View.Panels.OtherPanel;
import View.Panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

        gbc.ipady=120;
        gbc.ipadx=3;
        gbc.weightx=4;
        gbc.weighty=5;
        gbc.gridx=0;
        gbc.gridy=0;
        add(tablePanel,gbc);

        gbc.ipady=0;
        gbc.ipadx=0;
        gbc.weightx=1;
        gbc.weighty=1;
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

        setSize(new Dimension(900,600));
        this.setTitle("Add Pet To Customer");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        controller=new AddPetToCustomerController(this,customer);
        addPetToCustomer();
        deletePetFromCustomer();
        updatePet();
        selectedRow();
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

    public void addPetToCustomer(){
        getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addPetToCustomer();
            }
        });
    }

    public void deletePetFromCustomer(){
        getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deletePetFromCustomer();
            }
        });
    }

    public void updatePet(){
        getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updatePetOfCustomer();
            }
        });
    }

    public void selectedRow(){
        getTablePanel().addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.addSelectedRow();
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
