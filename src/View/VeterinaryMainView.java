package View;

import Model.Appointment;
import View.Panels.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeterinaryMainView extends JFrame {
    private MainMenu mainMenu;
    private JPanel panel;
    private MedicinesView medicineView;
    private PersonsView personsView;
    private AppointmentsView appointmentsView;
    static final String CUSTOMER="Customers";
    static final String APPOINTMENT="Appointments";
    static final String MEDICINE="Medicines";

    public VeterinaryMainView(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());
        mainMenu = new MainMenu();
        add(mainMenu, BorderLayout.LINE_START);

        medicineView = new MedicinesView();
        personsView = new PersonsView();
        appointmentsView = new AppointmentsView();

        panel = new JPanel(new CardLayout());
        panel.add(personsView,CUSTOMER);
        panel.add(appointmentsView, APPOINTMENT);
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
                cl.show(panel, APPOINTMENT);
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

    public MedicinesView getMedicineView() {
        return medicineView;
    }

    public PersonsView getPersonsView() {
        return personsView;
    }

    public AppointmentsView getAppointmentsView() {
        return appointmentsView;
    }
}
