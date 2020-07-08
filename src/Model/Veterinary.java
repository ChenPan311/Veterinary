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

    public static void main(String[] args) {

        char[] pass = {'1', '3', '2', '4'};
        LoginDialog loginDialog = new LoginDialog("Login");

        loginDialog.addSignInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginDialog.getVet_rb().isSelected()) {
                    if (Arrays.equals(loginDialog.getPassword_pf().getPassword(), pass) && loginDialog.getUsername_tf().getText().equals("vet")) {
                        JOptionPane.showMessageDialog(loginDialog, "Success!", "OK", 1);
                        VeterinaryMainView frame = new VeterinaryMainView("Veterinary");
                        frame.setSize(1000, 600);
                        frame.setLocationRelativeTo(null);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        loginDialog.dispose();
                        frame.setVisible(true);
                    } else JOptionPane.showMessageDialog(loginDialog, "Wrong Username or Password", "Failed", 0);
                } else {
                    if (loginDialog.getCustomer_rb().isSelected()) {
                        if (Arrays.equals(loginDialog.getPassword_pf().getPassword(), pass) && !loginDialog.getUsername_tf().getText().equals("")) {
                            JOptionPane.showMessageDialog(loginDialog, "Success!");
//                            CustomerMainController customerMainController = CustomerMainController.getInstance(customerMainView);
                            Customer customer = PersonManager.singletonPersonManager("persons3").getCustomerById(loginDialog.getUsername_tf().getText());
                            CustomerMainView customerMainView = new CustomerMainView("Customer",customer);
                            customerMainView.setSize(1000, 600);
                            customerMainView.setLocationRelativeTo(null);
                            loginDialog.dispose();
                            customerMainView.setVisible(true);

                        } else JOptionPane.showMessageDialog(loginDialog, "Wrong Username or Password", "Failed", 0);
                    }
                }
            }
        });

    }
}
