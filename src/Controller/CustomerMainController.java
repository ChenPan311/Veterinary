package Controller;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Model.Appointment;
import Model.AppointmentSummary;
import Model.Customer;
import Model.CustomersMedicinesAppointmentsModelView;
import View.CustomerMainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainController {
    CustomerMainView view;
    CustomersMedicinesAppointmentsModelView model;
    Customer customer;


    public CustomerMainController(CustomerMainView view, CustomersMedicinesAppointmentsModelView model, Customer customer) {
        this.view = view;
        this.model = model;
        this.customer = customer;
//        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointmentsForCustomer(customer.getId()));
//        view.setId(customer.getId());
//        view.setAddress(customer.getAddress());
//        view.setEmail(customer.getEmail());
//        view.setName(customer.getName());
//        view.setPhoneNumber(customer.getPhoneNumber());

//        view.addAppointmentListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (view.validateFields()) {
//                        if (model.getPersonManager().searchPetForCustomer(customer.getId(), view.getPetId())) {
//                            if (model.getPersonManager().searchById(view.getVetId())) {
//                                Appointment appointment = new Appointment();
//                                appointment.setCustomerId(customer.getId());
//                                appointment.setPetId(view.getPetId());
//                                appointment.setVetId(view.getVetId());
//                                appointment.setDay(view.getDatePicker());
//                                appointment.setHour(view.getTimePicker());
//                                appointment.setTreatment(view.getTreatment());
//                                appointment.setTreatmentDescription(view.getTreatmentDescription());
//                                appointment.setSummary(new AppointmentSummary());
//                                try {
//                                    model.getAppointmentManager().addAppointment(appointment);
//                                    view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
//                                    view.getTablePanel().refresh();
//                                } catch (ApponitmentAlreadyExistsException ex) {
//                                    ex.printStackTrace();
//                                }
//                                JOptionPane.showMessageDialog(view, "Added");
//                            } else JOptionPane.showMessageDialog(view, "There Is No Such Vet With That Id!");
//                        } else JOptionPane.showMessageDialog(view, "There Is No Such Pet For That Customer!");
//                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
//            }
//        });

//        view.deleteAppointmentListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
//                    int row = view.getTablePanel().getTable().getSelectedRow();
//                    Appointment appointment = new Appointment();
//                    appointment.setCustomerId(view.getTablePanel().getTable().getValueAt(row,0).toString());
//                    appointment.setPetId(view.getTablePanel().getTable().getValueAt(row,1).toString());
//                    appointment.setVetId(view.getTablePanel().getTable().getValueAt(row,2).toString());
//                    appointment.setDay(view.getTablePanel().getTable().getValueAt(row,3).toString());
//                    appointment.setHour(view.getTablePanel().getTable().getValueAt(row,4).toString());
//                    Appointment appointmentToDelete = model.getAppointmentManager().getAppointmentByAppointment(appointment);
//                    try {
//                        model.getAppointmentManager().removeAppointment(appointmentToDelete);
//                        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
//                        view.getTablePanel().refresh();
//                    } catch (AppointmentNotExistException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        });


//        view.updateCustomerData(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (view.validateFields()) {
//                    customer.setId(view.getId());
//                    customer.setName(view.getName());
//                    customer.setPhoneNumber(view.getPhoneNumber());
//                    customer.setEmail(view.getEmail());
//                    customer.setAddress(view.getAddress());
//                    model.getPersonManager().updatePerson(customer);
//                    view.getTablePanel().setPersonsData(model.getPersonManager().getPersons());
//                    view.getTablePanel().refresh();
//                    JOptionPane.showMessageDialog(view, "Updated!");
//                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
//            }
//        });
    }

    public void addAppointment(){
        if (view.validateFields()) {
            if (model.getPersonManager().searchPetForCustomer(customer.getId(), view.getPetId())) {
                if (model.getPersonManager().searchById(view.getVetId())) {
                    Appointment appointment = new Appointment();
                    appointment.setCustomerId(customer.getId());
                    appointment.setPetId(view.getPetId());
                    appointment.setVetId(view.getVetId());
                    appointment.setDay(view.getDatePicker());
                    appointment.setHour(view.getTimePicker());
                    appointment.setTreatment(view.getTreatment());
                    appointment.setTreatmentDescription(view.getTreatmentDescription());
                    appointment.setSummary(new AppointmentSummary());
                    try {
                        model.getAppointmentManager().addAppointment(appointment);
                        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                        view.getTablePanel().refresh();
                    } catch (ApponitmentAlreadyExistsException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(view, "Added");
                } else JOptionPane.showMessageDialog(view, "There Is No Such Vet With That Id!");
            } else JOptionPane.showMessageDialog(view, "There Is No Such Pet For That Customer!");
        } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
    }

    public void deleteAppointment(){
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            Appointment appointment = new Appointment();
            appointment.setCustomerId(view.getTablePanel().getTable().getValueAt(row,0).toString());
            appointment.setPetId(view.getTablePanel().getTable().getValueAt(row,1).toString());
            appointment.setVetId(view.getTablePanel().getTable().getValueAt(row,2).toString());
            appointment.setDay(view.getTablePanel().getTable().getValueAt(row,3).toString());
            appointment.setHour(view.getTablePanel().getTable().getValueAt(row,4).toString());
            Appointment appointmentToDelete = model.getAppointmentManager().getAppointmentByAppointment(appointment);
            try {
                model.getAppointmentManager().removeAppointment(appointmentToDelete);
                view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                view.getTablePanel().refresh();
            } catch (AppointmentNotExistException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateCustomer(){
        if (view.validateFields()) {
            customer.setId(view.getId());
            customer.setName(view.getName());
            customer.setPhoneNumber(view.getPhoneNumber());
            customer.setEmail(view.getEmail());
            customer.setAddress(view.getAddress());
            model.getPersonManager().updatePerson(customer);
            view.getTablePanel().setPersonsData(model.getPersonManager().getPersons());
            view.getTablePanel().refresh();
            JOptionPane.showMessageDialog(view, "Updated!");
        } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
    }

    public void setCustomerData(){
        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointmentsForCustomer(customer.getId()));
        view.setId(customer.getId());
        view.setAddress(customer.getAddress());
        view.setEmail(customer.getEmail());
        view.setName(customer.getName());
        view.setPhoneNumber(customer.getPhoneNumber());
    }
}
