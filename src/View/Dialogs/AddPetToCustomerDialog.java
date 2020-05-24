package View.Dialogs;

import Model.Pet;
import Model.TablesModels.PetTableModel;
import View.Panels.CatPanel;
import View.Panels.DogPanel;
import View.Panels.OtherPanel;
import View.Panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

    public AddPetToCustomerDialog() {
        create();
        setBackground(Color.ORANGE);
        this.setVisible(true);
    }

    private void create() {

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

    public void addPetToCustomerListener(ActionListener actionListener) {
        addBtn.addActionListener(actionListener);
    }

    public void deletePetFromCustomerListener(ActionListener actionListener) {
        deleteBtn.addActionListener(actionListener);
    }

    public void updatePetOfCustomerListener(ActionListener actionListener) {
        updateBtn.addActionListener(actionListener);
    }



    public Boolean validateFields() {
        String string = (String) petChooser_cb.getSelectedItem();
        if (string.equals("Dog")) {
            return !(dogPanel.getPetId_tf().getText().trim().equals("") ||
                    dogPanel.getName_tf().getText().trim().equals("") ||
                    dogPanel.getDateOfBirth_tf().getText().trim().equals("") ||
                    dogPanel.getColor_tf().getText().trim().equals("") ||
                    dogPanel.getWeight_tf().getText().trim().equals("") ||
                    dogPanel.getBreed_tf().getText().trim().equals("") ||
                    dogPanel.getSize_tf().getText().trim().equals("") ||
                    dogPanel.isSelected());
        } else if (string.equals("Cat")) {
            return !(catPanel.getPetId_tf().getText().equals("") ||
                    catPanel.getName_tf().getText().equals("") ||
                    catPanel.getDateOfBirth_tf().getText().equals("") ||
                    catPanel.getColor_tf().getText().equals("") ||
                    catPanel.getWeight_tf().getText().equals("") ||
                    catPanel.getBreed_tf().getText().equals("") ||
                    catPanel.isSelected());
        } else if (string.equals("Other")) {
            return !(otherPanel.getPetId_tf().getText().equals("") ||
                    otherPanel.getName_tf().getText().equals("") ||
                    otherPanel.getDateOfBirth_tf().getText().equals("") ||
                    otherPanel.getColor_tf().getText().equals("") ||
                    otherPanel.getWeight_tf().getText().equals("") ||
                    otherPanel.getTypeOfPet_tf().getText().equals("") ||
                    otherPanel.getInfo_tf().getText().equals("") ||
                    otherPanel.isSelected());

        }
        return false;

    }



}
