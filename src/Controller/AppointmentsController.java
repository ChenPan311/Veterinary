package Controller;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import Model.Appointment;
import Model.AppointmentSummary;
import Model.CustomersMedicinesAppointmentsModelView;
import Model.Medicine;
import Model.TablesModels.AppointmentTableModel;
import View.AppointmentsView;

import javax.swing.*;
import java.util.*;

public class AppointmentsController extends Observable implements Observer {
    private static AppointmentsController appointmentsController;
    private AppointmentsView view;
    private CustomersMedicinesAppointmentsModelView model;

    public static AppointmentsController getInstance(AppointmentsView view){
        if(appointmentsController==null){
            appointmentsController = new AppointmentsController(view);
        }
        return appointmentsController;
    }

    private AppointmentsController(AppointmentsView view) {
        this.view = view;
        this.model = new CustomersMedicinesAppointmentsModelView();
        addObserver(view);
        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
        view.getView().setMedicines((HashMap<Medicine, Integer>) model.getMedicineManager().getMedicinesAndQuantity());
    }

    public void addAppointment(Appointment appointment) throws ApponitmentAlreadyExistsException {
        model.getAppointmentManager().addAppointment(appointment);
    }

    public void deleteAppointment(Appointment appointment) throws AppointmentNotExistException {
        model.getAppointmentManager().removeAppointment(appointment);
    }

    public void updateAppointment(Appointment appointment) throws ApponitmentAlreadyExistsException, AppointmentNotExistException {
        model.getAppointmentManager().updateAppointment(appointment);
    }

    public void addAppointmentSummary(Appointment appointment, AppointmentSummary appointmentSummary ) {
        model.getAppointmentManager().addAppointmentSummary(appointment, appointmentSummary);
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
        return model.getPersonManager().searchPetForCustomer(customerId,petId);
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
        model.getMedicineManager().decreaseQuantityFromMedicineStock(medicine,quantity);
    }
}
