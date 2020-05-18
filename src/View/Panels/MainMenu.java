package View.Panels;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    JButton addCustomer,addMedicine,addPet;

    public MainMenu() {
        addCustomer=new JButton("Add a Customer");
        addMedicine=new JButton("Add Medicine");
        addPet=new JButton("Add Pet");

        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 3, 20, 3);
        gbc.ipady = 3;
        gbc.ipadx = 3;

        gbc.gridx=0;
        gbc.gridy=0;
        add(addCustomer,gbc);

        gbc.gridy=1;
        add(addMedicine,gbc);

        gbc.gridy=2;
        add(addPet,gbc);
    }

    public JButton getAddCustomer() {
        return addCustomer;
    }

    public JButton getAddMedicine() {
        return addMedicine;
    }

    public JButton getAddPet() {
        return addPet;
    }
}
