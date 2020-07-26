package Controller;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Model.Appointment;
import Model.Customer;
import Model.CustomersMedicinesAppointmentsModelView;

import java.util.Set;

public class CustomerMainController {
    private CustomersMedicinesAppointmentsModelView model;
    private Customer customer;


    public CustomerMainController(Customer customer) {
        this.model = new CustomersMedicinesAppointmentsModelView();
        this.customer = customer;
    }

    public void addAppointment(Appointment appointment) throws ApponitmentAlreadyExistsException {
        model.getAppointmentManager().addAppointment(appointment);
    }

    public void deleteAppointment(Appointment appointment) throws AppointmentNotExistException {
        model.getAppointmentManager().removeAppointment(appointment);

    }

    public void updateCustomer(Customer customer) {
        model.getPersonManager().updatePerson(customer);
    }


    public boolean getVet(String id) {
        return model.getPersonManager().searchById(id);
    }

    public Set<Appointment> getSetAppointmentsForCustomer(String id) {
        return model.getAppointmentManager().getSetAppointmentsForCustomer(id);
    }

    public Appointment getAppointmentByAppointment(Appointment appointment) {
        return model.getAppointmentManager().getAppointmentByAppointment(appointment);
    }

    public Customer getCustomer() {
        return customer;
    }
}
