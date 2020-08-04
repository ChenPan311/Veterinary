package controllers;

import exceptions.PersonAlreadyExistException;
import exceptions.PersonNotExistException;
import Model.Customer;
import Model.Person;
import Model.PersonManager;
import Model.tablesModels.PersonTableModel;
import view.dialogs.AddPetToCustomerDialog;
import view.PersonsView;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PersonsController extends Observable implements Observer {
    private static PersonsController personsController;
    private PersonsView view;
    private PersonManager model;

public static PersonsController getInstance(PersonsView view){
    if(personsController==null){
        personsController = new PersonsController(view);
    }
    return personsController;
}

    private PersonsController(PersonsView view) {
        this.view = view;
        this.model = PersonManager.singletonPersonManager("persons3");
        view.getTablePanel().setPersonsData(model.getPersons());
    }

    public void addNewCustomer(){
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

    public void deleteCustomer(){
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

    public void updateCustomer(){
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

    public void clearFields(){
        view.getView().clearFields();
    }

    public void mouseClickedOnTable(){
                PersonTableModel model = (PersonTableModel) view.getTablePanel().getTable().getModel();
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                view.setId(model.getValueAt(selectedRowIndex, 0).toString());
                view.setName(model.getValueAt(selectedRowIndex, 1).toString());
                view.setPhoneNumber(model.getValueAt(selectedRowIndex, 2).toString());
                view.setEmail(model.getValueAt(selectedRowIndex, 3).toString());
                view.setAddress(model.getValueAt(selectedRowIndex, 4).toString());
    }

    public void addPetToCustomer(){
        int rowSelected = view.getTablePanel().getTable().getSelectedRow();
        if ( rowSelected != -1) {
            Customer customer=model.getCustomerById(view.getId());
            AddPetToCustomerDialog viewp = new AddPetToCustomerDialog(customer);
            viewp.getTablePanel().setPetDataForCustomer(customer.getPetList());
            new AddPetToCustomerController(viewp,customer);
        }
        else JOptionPane.showMessageDialog(view, "Select Customer First!");
    }

    @Override
    public void update(Observable o, Object arg) {
        view.getTablePanel().setPersonsData(model.getPersons());
        setChanged();
        notifyObservers();
    }
}
