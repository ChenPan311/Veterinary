package View;

import Controller.AddPetToCustomerController;
import Controller.PersonsController;
import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Model.Customer;
import Model.Person;
import Model.PersonManager;
import Model.TablesModels.PersonTableModel;
import Model.Veterinary;
import View.Dialogs.AddPetToCustomerDialog;
import View.Panels.TablePanel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class PersonsView extends JPanel implements Observer {
    private TablePanel tablePanel;
    private RegisterCustomerView view;
    private PersonsController controller;

    public PersonsView() {
        view = new RegisterCustomerView();
        tablePanel = new TablePanel(new PersonTableModel());
        controller = PersonsController.getInstance();


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);

        gbc.ipady = 120;
        gbc.ipadx = 3;
        gbc.weightx = 4;
        gbc.weighty = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(tablePanel, gbc);


        gbc.ipady = 3;
        gbc.weighty = 1;
        gbc.gridy = 1;
        add(view, gbc);

        setBackground(Color.ORANGE);

        getTablePanel().setPersonsData(controller.getPersons());

        addCustomer();
        deleteCustomer();
        updateCustomer();
        clearFields();
        addPetToCustomer();
        mouseClicked();


    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public RegisterCustomerView getView() {
        return view;
    }

    private void addCustomer() {
        view.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    Customer customer = new Customer();
                    customer.setId(getId());
                    customer.setName(getName());
                    customer.setAddress(getAddress());
                    customer.setPhoneNumber(getPhoneNumber());
                    customer.setEmail(getEmail());
                    try {
                        controller.addNewCustomer(customer);
                        getTablePanel().setPersonsData(controller.getPersons());
                        getTablePanel().refresh();
                        clearFields();
                        JOptionPane.showMessageDialog(PersonsView.this, "Success");
                    } catch (PersonAlreadyExistException personAlreadyExistException) {
                        JOptionPane.showMessageDialog(PersonsView.this, "Customer Already Exist!");
                    }
                } else JOptionPane.showMessageDialog(PersonsView.this, "Fill All Fields!");
            }
        });
    }

    private void deleteCustomer() {
        view.getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = getTablePanel().getTable().getSelectedRow();
                    String id = (String) getTablePanel().getTable().getValueAt(row, 0);
                    Customer customer = controller.getCustomerById(id);
                    try {
                        controller.deleteCustomer(customer);
                        getTablePanel().setPersonsData(controller.getPersons());
                        getTablePanel().refresh();
                    } catch (PersonNotExistException personNotExistException) {
                        JOptionPane.showMessageDialog(PersonsView.this, "Person Not Exist!");
                    }
                }
            }
        });
    }

    private void updateCustomer() {
        view.getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = getTablePanel().getTable().getSelectedRow();
                    Customer customer = controller.getCustomerById(getId());
                    if (getView().validateFields()) {
                        customer.setId(getId());
                        customer.setName(getName());
                        customer.setPhoneNumber(getPhoneNumber());
                        customer.setEmail(getEmail());
                        customer.setAddress(getAddress());
                        controller.updateCustomer(customer);
                        getTablePanel().setPersonsData(controller.getPersons());
                        getTablePanel().refresh();
                        JOptionPane.showMessageDialog(view, "Updated!");
                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                }
            }
        });
    }

    private void clearFields() {
        view.getClearBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               view.clearFields();
            }
        });
    }

    private void addPetToCustomer() {
        view.getAddPetBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = getTablePanel().getTable().getSelectedRow();
                if (rowSelected != -1) {
                    Customer customer = controller.getCustomerById(getId());
                    AddPetToCustomerDialog viewp = new AddPetToCustomerDialog(customer);
                    viewp.getTablePanel().setPetDataForCustomer(customer.getPetList());
                } else JOptionPane.showMessageDialog(view, "Select Customer First!");
            }
        });
    }

    public void mouseClicked() {
        tablePanel.addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PersonTableModel model = (PersonTableModel) getTablePanel().getTable().getModel();
                int selectedRowIndex = getTablePanel().getTable().getSelectedRow();
                setId(model.getValueAt(selectedRowIndex, 0).toString());
                setName(model.getValueAt(selectedRowIndex, 1).toString());
                setPhoneNumber(model.getValueAt(selectedRowIndex, 2).toString());
                setEmail(model.getValueAt(selectedRowIndex, 3).toString());
                setAddress(model.getValueAt(selectedRowIndex, 4).toString());
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
    }


    public String getId() {
        return view.getId_tf().getText();
    }

    public String getName() {
        return view.getName_tf().getText();
    }

    public String getAddress() {
        return view.getAddress_tf().getText();
    }

    public String getPhoneNumber() {
        return view.getPhoneNumber_tf().getText();
    }

    public String getEmail() {
        return view.getEmail_tf().getText();
    }

    public void setId(String id) {
        view.getId_tf().setText(id);
    }

    public void setName(String name) {
        view.getName_tf().setText(name);
    }

    public void setAddress(String address) {
        view.getAddress_tf().setText(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        view.getPhoneNumber_tf().setText(phoneNumber);
    }

    public void setEmail(String email) {
        view.getEmail_tf().setText(email);
    }

    @Override
    public void update(Observable o, Object arg) {
        tablePanel.refresh();
    }
}
