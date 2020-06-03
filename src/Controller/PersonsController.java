package Controller;

import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Model.Customer;
import Model.Person;
import Model.PersonManager;
import Model.TablesModels.PersonTableModel;
import View.Dialogs.AddPetToCustomerDialog;
import View.PersonsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class PersonsController extends Observable implements Observer {
    private PersonsView view;
    private PersonManager model;

    public PersonsController(PersonsView view, PersonManager model) {
        this.view = view;
        this.model = model;
        addObserver(view);
        view.getTablePanel().setPersonsData(model.getPersons());

        view.getView().addNewCustomerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getView().validateFields()) {
                    if (model.searchById(view.getId())) {
                        JOptionPane.showMessageDialog(view, "Customer Already Exist!");
                    } else {
                        Customer customer = new Customer();
                        customer.setId(view.getId());
                        customer.setName(view.getName());
                        customer.setAddress(view.getAddress());
                        customer.setPhoneNumber(view.getPhoneNumber());
                        customer.setEmail(view.getEmail());
                        customer.setCustomerNumber(model.getRandom().nextInt(1024));
                        try {
                            model.addPerson(customer);
                        } catch (PersonAlreadyExistException ex) {
                            ex.printStackTrace();
                        }
                        view.getView().clearFields();
                        view.getTablePanel().setPersonsData(model.getPersons());
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
                    String id = (String) view.getTablePanel().getTable().getValueAt(row, 0);
                    for(Person person:model.getPersons())
                        if(person.getId().equals(id)) {
                            try {
                                model.removePerson(person);
                            } catch (PersonNotExistException ex) {
                                ex.printStackTrace();
                            }
                        }
                    view.getTablePanel().setPersonsData(model.getPersons());
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
                view.setId(model.getValueAt(selectedRowIndex, 0).toString());
                view.setName(model.getValueAt(selectedRowIndex, 1).toString());
                view.setPhoneNumber(model.getValueAt(selectedRowIndex, 2).toString());
                view.setEmail(model.getValueAt(selectedRowIndex, 3).toString());
                view.setAddress(model.getValueAt(selectedRowIndex, 4).toString());
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
                        customer.setId(view.getId());
                        customer.setName(view.getName());
                        customer.setPhoneNumber(view.getPhoneNumber());
                        customer.setEmail(view.getEmail());
                        customer.setAddress(view.getAddress());
                        model.updatePerson(customer);
                        view.getTablePanel().setPersonsData(model.getPersons());
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
                    AddPetToCustomerDialog viewp = new AddPetToCustomerDialog();
                    Customer customer=model.getCustomerById(view.getId());
                    viewp.getTablePanel().setPetDataForCustomer(customer.getPetList());
                    new AddPetToCustomerController(model,viewp,customer);
                }
                else JOptionPane.showMessageDialog(view, "Select Customer First!");
            }
        });


    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
