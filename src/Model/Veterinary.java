package Model;

import Controller.*;
import View.CustomerMainView;
import View.Dialogs.LoginDialog;
import View.VeterinaryMainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Veterinary {
    private String clinicName;
    private String clinicAddress;
    private String clinicPhone;
    private PersonManager personManager;
    private MedicineManager medicineManager;
    private AppointmentManager appointmentManager;

    public Veterinary(String clinicName) {
        this.clinicName = clinicName;
    }

    public PersonManager getPersonManager() {
        return personManager;
    }

    public MedicineManager getMedicineManager() {
        return medicineManager;
    }

    public AppointmentManager getAppointmentManager() {
        return appointmentManager;
    }

    public static void main(String[] args) {
//        Veterinary veterinary = new Veterinary("Veterinary");
        VeterinaryMainView frame = new VeterinaryMainView("veterinary");
        frame.setVisible(false);

        CustomerMainView customerMainView = new CustomerMainView("Cusi");
        customerMainView.setVisible(false);

//        veterinary.medicineManager = MedicineManager.singletonMedicineManager();
//        veterinary.personManager = PersonManager.singletonPersonManager();
//        veterinary.appointmentManager = AppointmentManager.singletonAppointmentManager();

        CustomersMedicinesAppointmentsModelView model = new CustomersMedicinesAppointmentsModelView();

        PersonsController personsController = PersonsController.getInstance(frame.getPersonsView());
        MedicineController medicineController = new MedicineController(frame.getMedicineView(), model.getMedicineManager());
        AppointmentsController appointmentsController = new AppointmentsController(frame.getAppointmentsView(), model);


        frame.setSize(1000, 600);
        customerMainView.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        char[] pass = {'1', '3', '2', '4'};
        LoginDialog loginDialog = new LoginDialog("Login");

        loginDialog.addSignInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginDialog.getVet_rb().isSelected()) {
                    if (Arrays.equals(loginDialog.getPassword_pf().getPassword(), pass) && loginDialog.getUsername_tf().getText().equals("vet")) {
                        JOptionPane.showMessageDialog(loginDialog, "Success!","Failed",1);
                        MainController mainController = new MainController(frame, personsController, medicineController, appointmentsController);
                        frame.setLocationRelativeTo(null);
                        loginDialog.dispose();
                        frame.setVisible(true);
                    } else JOptionPane.showMessageDialog(loginDialog, "Wrong Username or Password","Failed",0);
                } else {
                    if (loginDialog.getCustomer_rb().isSelected()) {
                        if (Arrays.equals(loginDialog.getPassword_pf().getPassword(), pass) && !loginDialog.getUsername_tf().getText().equals("")) {
                            JOptionPane.showMessageDialog(loginDialog, "Success!");
                            CustomerMainController customerMainController = new CustomerMainController(customerMainView, model, model.getPersonManager().getCustomerById(loginDialog.getUsername_tf().getText()));
                            customerMainView.setLocationRelativeTo(null);
                            loginDialog.dispose();
                            customerMainView.setVisible(true);

                        }else JOptionPane.showMessageDialog(loginDialog, "Wrong Username or Password","Failed",0);
                    }
                }
            }
        });

    }
}
