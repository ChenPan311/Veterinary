package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddMedicineView extends JPanel {
    private JLabel id_tv, name_tv, type_tv, quantity_tv;
    private JTextField id_tf, name_tf, quantity_tf;
    private JComboBox<String> type_cb;
    private String[] medicineType = {"Antibiotics", "Opioid pain relievers", "Steroids", "Antiparasitics", "Behavior-modifying drugs and sedatives"};
    private JButton addBtn,deleteBtn,updateBtn;

    public AddMedicineView() {
        id_tv = new JLabel("Medicine Id: ");
        name_tv = new JLabel("Medicine Name: ");
        type_tv = new JLabel("Medicine Type: ");
        quantity_tv = new JLabel("Quantity: ");

        id_tf = new JTextField(20);
        name_tf = new JTextField(20);
        quantity_tf = new JTextField(20);

        type_cb = new JComboBox<>(medicineType);

        addBtn = new JButton("Add");
        deleteBtn = new JButton("Delete");
        updateBtn = new JButton("Update");

        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.ipady = 3;
        gbc.ipadx = 3;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(id_tv, gbc);
        gbc.gridx = 1;
        add(id_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(name_tv, gbc);
        gbc.gridx = 1;
        add(name_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(type_tv, gbc);
        gbc.gridx = 1;
        add(type_cb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(quantity_tv, gbc);
        gbc.gridx = 1;
        add(quantity_tf, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 4;
        add(addBtn, gbc);

        gbc.gridy = 5;
        add(deleteBtn, gbc);

        gbc.gridy = 6;
        add(updateBtn, gbc);
    }

    public void addMedicineToInventory(ActionListener actionListener) {
        addBtn.addActionListener(actionListener);
    }

    public void deleteMedicineFromInventory(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }

    public void updateMedicineInInventory(ActionListener actionListener){
        updateBtn.addActionListener(actionListener);
    }

    public Boolean validateFields() {
        return !(id_tf.getText().equals("")||name_tf.getText().equals("")||quantity_tf.getText().equals(""));
    }

    public JTextField getId_tf() {
        return id_tf;
    }

    public JTextField getName_tf() {
        return name_tf;
    }

    public JTextField getQuantity_tf() {
        return quantity_tf;
    }

    public JComboBox<String> getType_cb() {
        return type_cb;
    }

    public JButton getAddBtn() {
        return addBtn;
    }
}

