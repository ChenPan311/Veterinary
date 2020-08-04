package controllers;

import exceptions.AppointmentNotExistException;
import exceptions.ApponitmentAlreadyExistsException;
import exceptions.MedicineNotExistException;
import exceptions.MedicineQuantityInsufficient;
import Model.*;
import Model.Date;
import view.AppointmentsView;

import java.util.*;

public class AppointmentsController extends Observable implements Observer {
    private static AppointmentsController appointmentsController;
    private AppointmentsView view;
    private CustomersMedicinesAppointmentsModelView model;

    public static AppointmentsController getInstance(AppointmentsView view) {
        if (appointmentsController == null) {
            appointmentsController = new AppointmentsController(view);
        }
        return appointmentsController;
    }

    private AppointmentsController(AppointmentsView view) {
        this.view = view;
        this.model = new CustomersMedicinesAppointmentsModelView();
        addObserver(view);
    }

    public void addAppointment(Appointment appointment) throws ApponitmentAlreadyExistsException {
        model.getAppointmentManager().addAppointment(appointment);
    }

    public void deleteAppointment(int rowId) throws AppointmentNotExistException {
        Appointment appointment = getArrayAppointments().get(rowId);
        model.getAppointmentManager().removeAppointment(appointment);
    }

    public void updateAppointment(int rowId, Date date, String petId, String customerId, String vetId, String treatment, String treatmentDescription, AppointmentSummary appointmentSummary) throws ApponitmentAlreadyExistsException, AppointmentNotExistException {
        Appointment appointment = getArrayAppointments().get(rowId);
        appointment.setCustomerId(customerId);
        if (searchPetForCustomer(appointment.getCustomerId(), petId)) {
            appointment.setPetId(petId);
        }
        appointment.setVetId(vetId);
        appointment.setDay(date.getDay());
        appointment.setHour(date.getHour());
        appointment.setTreatment(treatment);
        appointment.setTreatmentDescription(treatmentDescription);
        model.getAppointmentManager().updateAppointment(appointment);

    }

    public void deleteAppointmentSummary(Appointment appointment) {
        model.getAppointmentManager().removeAppointmentSummary(appointment);
    }


    @Override
    public void update(Observable o, Object arg) {
        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
        view.getView().setMedicines((HashMap<Medicine, Integer>) model.getMedicineManager().getMedicinesAndQuantity());
        setChanged();
        notifyObservers();
    }

    public boolean searchById(String customerId) {
        return model.getPersonManager().searchById(customerId);
    }

    public boolean searchPetForCustomer(String customerId, String petId) {
        return model.getPersonManager().searchPetForCustomer(customerId, petId);
    }

    public Set<Appointment> getSetAppointments() {
        return model.getAppointmentManager().getSetAppointments();
    }

    public List<Appointment> getArrayAppointments() {
        return model.getAppointmentManager().getArrayAppointments();
    }

    public Map<Medicine, Integer> getMedicinesAndQuantity() {
        return model.getMedicineManager().getMedicinesAndQuantity();
    }

    public void decreaseQuantityFromMedicineStock(Medicine medicine, int quantity) throws MedicineQuantityInsufficient, MedicineNotExistException {
        model.getMedicineManager().decreaseQuantityFromMedicineStock(medicine, quantity);
    }

    public void addAppointment(Date date, String petId, String customerId, String vetId, String treatment, String treatmentDescription, AppointmentSummary appointmentSummary) throws ApponitmentAlreadyExistsException {
        Appointment appointment = new Appointment(date, petId, customerId, vetId, treatment, treatmentDescription, appointmentSummary);
        model.getAppointmentManager().addAppointment(appointment);
    }

    public void addAppointmentSummary(Appointment appointment, AppointmentSummary appointmentSummary, String medicineToAdd, int quantity) throws MedicineQuantityInsufficient, MedicineNotExistException {
        Map<Medicine, Integer> medicines = getMedicinesAndQuantity();
        for (Medicine medicine : medicines.keySet()) {
            if (medicine.getName().equals(medicineToAdd)) {
                decreaseQuantityFromMedicineStock(medicine, quantity);
                model.getAppointmentManager().addAppointmentSummary(appointment, appointmentSummary);
            }

        }
    }
}
