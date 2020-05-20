package Controller;

import Model.Customer;
import Model.Person;
import Model.PersonManager;
import View.RegisterCustomerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterCustomerController {
    private PersonManager model;
    private RegisterCustomerView view;

    public RegisterCustomerController(PersonManager model, RegisterCustomerView view) {
        this.model = model;
        this.view = view;
        view.addNewCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    if(model.searchById(view.getId_tf().getText())){
                        JOptionPane.showMessageDialog(view,"Customer Already Exist!");
                    }else {
                        Customer customer = new Customer();
                        customer.setId(view.getId_tf().getText());
                        customer.setName(view.getName_tf().getText());
                        customer.setAddress(view.getAddress_tf().getText());
                        customer.setPhoneNumber(view.getPhoneNumber_tf().getText());
                        customer.setEmail(view.getEmail_tf().getText());
                        customer.setCustomerNumber(model.getRandom().nextInt(16));
                        model.addPerson(customer);
                        System.out.println(customer);
                        view.clearFields();
                        JOptionPane.showMessageDialog(view, "Success");
                    }
                } else JOptionPane.showMessageDialog(view,"Fill All Fields!");
            }
        });

    }


}
