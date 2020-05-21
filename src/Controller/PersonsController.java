package Controller;

import Model.*;
import Model.TablesModels.PersonTableModel;
import View.Dialogs.AddPetToCustomerDialog;
import View.PersonsView;

import javax.swing.*;
import java.awt.event.*;

public class PersonsController {
    private PersonsView view;
    private PersonManager model;

    public PersonsController(PersonsView view, PersonManager model) {
        this.view = view;
        this.model = model;
        view.getTablePanel().setPersonsData(model.getPersons());

        view.getView().addNewCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getView().validateFields()) {
                    if (model.searchById(view.getView().getId_tf().getText())) {
                        JOptionPane.showMessageDialog(view, "Customer Already Exist!");
                    } else {
                        Customer customer = new Customer();
                        customer.setId(view.getView().getId_tf().getText());
                        customer.setName(view.getView().getName_tf().getText());
                        customer.setAddress(view.getView().getAddress_tf().getText());
                        customer.setPhoneNumber(view.getView().getPhoneNumber_tf().getText());
                        customer.setEmail(view.getView().getEmail_tf().getText());
                        customer.setCustomerNumber(model.getRandom().nextInt(31));
                        model.addPerson(customer);
                        view.getView().clearFields();
                        view.getTablePanel().refresh();
                        JOptionPane.showMessageDialog(view, "Success");
                    }
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            }
        });

        view.getView().deleteCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    model.removeCustomer(row);
                    view.getTablePanel().refresh();
                }
            }
        });

        view.getView().clearFieldsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getView().clearFields();
            }
        });

        view.getTablePanel().addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PersonTableModel model = (PersonTableModel) view.getTablePanel().getTable().getModel();
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                view.getView().getId_tf().setText(model.getValueAt(selectedRowIndex, 0).toString());
                view.getView().getName_tf().setText(model.getValueAt(selectedRowIndex, 1).toString());
                view.getView().getPhoneNumber_tf().setText(model.getValueAt(selectedRowIndex, 2).toString());
                view.getView().getEmail_tf().setText(model.getValueAt(selectedRowIndex, 3).toString());
                view.getView().getAddress_tf().setText(model.getValueAt(selectedRowIndex, 4).toString());
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

        view.getView().updateCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    Customer customer = model.getCustomerByRowIndex(row);
                    if (view.getView().validateFields()) {
                        customer.setId(view.getView().getId_tf().getText());
                        customer.setName(view.getView().getName_tf().getText());
                        customer.setPhoneNumber(view.getView().getPhoneNumber_tf().getText());
                        customer.setEmail(view.getView().getEmail_tf().getText());
                        customer.setAddress(view.getView().getAddress_tf().getText());
                        view.getTablePanel().refresh();
                        JOptionPane.showMessageDialog(view, "Updated!");
                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                }
            }

        });

        view.getView().petManageOfCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = view.getTablePanel().getTable().getSelectedRow();
                if ( rowSelected != -1) {
                    AddPetToCustomerDialog view = new AddPetToCustomerDialog();
                    Customer customer=model.getCustomerByRowIndex(rowSelected);
                    view.getTablePanel().setPetDataForCustomer(model.getCustomerByRowIndex(rowSelected).getPetList());
                    new AddPetToCustomerController(model,view,customer);
                }
                else JOptionPane.showMessageDialog(view, "Select Customer First!");
            }
        });


    }
}
