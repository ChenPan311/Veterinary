package View;

import View.Panels.CatPanel;
import View.Panels.DogPanel;
import View.Panels.OtherPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddPetToCustomerView extends JPanel {
    private JComboBox<String> petChooser_cb;
    private JButton addBtn;
    private JPanel petPanel, comboBoxPetPanel, addPetPanel;
    private DogPanel dogPanel;
    private CatPanel catPanel;
    private OtherPanel otherPanel;
    final static String DOG_PANEL = "Dog";
    final static String CAT_PANEL = "Cat";
    final static String OTHER_PANEL = "Other";

    public AddPetToCustomerView() {

        String[] petOptions = {DOG_PANEL, CAT_PANEL, OTHER_PANEL};
        petChooser_cb = new JComboBox<String>(petOptions);
        petChooser_cb.setEditable(false);
        comboBoxPetPanel = new JPanel();
        comboBoxPetPanel.add(petChooser_cb);


        addPetPanel = new JPanel();
        addBtn = new JButton("Add");
        addPetPanel.add(addBtn);

        dogPanel = new DogPanel();
        catPanel = new CatPanel();
        otherPanel = new OtherPanel();

        petPanel = new JPanel(new CardLayout());
        petPanel.add(dogPanel, DOG_PANEL);
        petPanel.add(catPanel, CAT_PANEL);
        petPanel.add(otherPanel, OTHER_PANEL);


        add(comboBoxPetPanel, BorderLayout.NORTH);
        add(petPanel, BorderLayout.CENTER);
        add(addPetPanel, BorderLayout.SOUTH);
        setBackground(Color.ORANGE);


        petChooser_cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout) (petPanel.getLayout());
                cl.show(petPanel, (String) e.getItem());
            }
        });


    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JComboBox<String> getPetChooser_cb() {
        return petChooser_cb;
    }

    public void setPetChooser_cb(JComboBox<String> petChooser_cb) {
        this.petChooser_cb = petChooser_cb;
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

    public void addPetToCustomerListener(ActionListener actionListener) {
        addBtn.addActionListener(actionListener);
    }


    public Boolean validateFields() {
        String string = (String) petChooser_cb.getSelectedItem();
        if (string.equals("Dog")) {
            return !(dogPanel.getCustomerId_tf().getText().trim().equals("") ||
                    dogPanel.getPetId_tf().getText().trim().equals("") ||
                    dogPanel.getName_tf().getText().trim().equals("") ||
                    dogPanel.getDateOfBirth_tf().getText().trim().equals("") ||
                    dogPanel.getColor_tf().getText().trim().equals("") ||
                    dogPanel.getWeight_tf().getText().trim().equals("") ||
                    dogPanel.getBreed_tf().getText().trim().equals("") ||
                    dogPanel.getSize_tf().getText().trim().equals("")||
                    dogPanel.isSelected());
        } else if (string.equals("Cat")) {
            return !(catPanel.getCustomerId_tf().getText().equals("") ||
                    catPanel.getPetId_tf().getText().equals("") ||
                    catPanel.getName_tf().getText().equals("") ||
                    catPanel.getDateOfBirth_tf().getText().equals("") ||
                    catPanel.getColor_tf().getText().equals("") ||
                    catPanel.getWeight_tf().getText().equals("") ||
                    catPanel.getBreed_tf().getText().equals("")||
                    catPanel.isSelected());
        } else if (string.equals("Other")) {
            return !(otherPanel.getCustomerId_tf().getText().equals("") ||
                    otherPanel.getPetId_tf().getText().equals("") ||
                    otherPanel.getName_tf().getText().equals("") ||
                    otherPanel.getDateOfBirth_tf().getText().equals("") ||
                    otherPanel.getColor_tf().getText().equals("") ||
                    otherPanel.getWeight_tf().getText().equals("") ||
                    otherPanel.getTypeOfPet_tf().getText().equals("") ||
                    otherPanel.getInfo_tf().getText().equals("")||
                    otherPanel.isSelected());

        }
        return false;

    }


}
