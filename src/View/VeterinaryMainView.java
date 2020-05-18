package View;

import View.Panels.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeterinaryMainView extends JFrame {
    private MainMenu mainMenu;
    private JPanel panel;
    private AddMedicineView medicineView;
    private AddPetToCustomerView petToCustomerView;
    private RegisterCustomerView registerCustomerView;
    static final String CUSTOMER="Add Customer";
    static final String PET="Add Pet";
    static final String MEDICINE="Add Medicine";

    public VeterinaryMainView(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());
        mainMenu = new MainMenu();
        add(mainMenu, BorderLayout.LINE_START);

        medicineView = new AddMedicineView();
        petToCustomerView = new AddPetToCustomerView();
        registerCustomerView = new RegisterCustomerView();

        panel = new JPanel(new CardLayout());
        panel.add(registerCustomerView,CUSTOMER);
        panel.add(petToCustomerView,PET);
        panel.add(medicineView,MEDICINE);

        add(panel,BorderLayout.CENTER);

        mainMenu.getAddCustomer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, CUSTOMER);
            }
        });

        mainMenu.getAddPet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, PET);
            }
        });

        mainMenu.getAddMedicine().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, MEDICINE);
            }
        });

    }

    public void addCustomerAddingListener(ActionListener actionListener) {
        mainMenu.getAddCustomer().addActionListener(actionListener);
    }

    public void addMedicineAddingListener(ActionListener actionListener) {
        mainMenu.getAddMedicine().addActionListener(actionListener);
    }

    public void addPetAddingListener(ActionListener actionListener) {
        mainMenu.getAddPet().addActionListener(actionListener);
    }

    public AddMedicineView getMedicineView() {
        return medicineView;
    }

    public AddPetToCustomerView getPetToCustomerView() {
        return petToCustomerView;
    }

    public RegisterCustomerView getRegisterCustomerView() {
        return registerCustomerView;
    }
}
