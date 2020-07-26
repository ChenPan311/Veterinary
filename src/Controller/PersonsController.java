package Controller;

import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Model.Customer;
import Model.Person;
import Model.PersonManager;
import View.PersonsView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class PersonsController extends Observable implements Observer {
    private static PersonsController personsController;
    private PersonManager model;

    public static PersonsController getInstance() {
        if (personsController == null) {
            personsController = new PersonsController();
        }
        return personsController;
    }

    private PersonsController() {
        this.model = PersonManager.singletonPersonManager("persons3");
    }

    public void addNewCustomer(Customer customer) throws PersonAlreadyExistException {
        customer.setCustomerNumber(model.getRandom().nextInt(1024));
        model.addPerson(customer);
    }


    public void deleteCustomer(Customer customer) throws PersonNotExistException {
        model.removePerson(customer);
    }

    public void updateCustomer(Customer customer) {
        model.updatePerson(customer);
    }


    public Set<Person> getPersons() {
        return model.getPersons();
    }

    public Customer getCustomerById(String id) {
        return model.getCustomerById(id);
    }

    @Override
    public void update(Observable o, Object arg) {
        //view.getTablePanel().setPersonsData(model.getPersons());
        setChanged();
        notifyObservers();
    }
}
