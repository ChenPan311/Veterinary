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
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

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

    public void addAppointment() {
        if (view.getView().validateFields()) {
            if (model.getPersonManager().searchById(view.getCustomerId())) {
                if (model.getPersonManager().searchPetForCustomer(view.getCustomerId(), view.getPetId())) {
                    if (model.getPersonManager().searchById(view.getVetId())) {
                        Appointment appointment = new Appointment();
                        appointment.setCustomerId(view.getCustomerId());
                        appointment.setPetId(view.getPetId());
                        appointment.setVetId(view.getVetId());
                        appointment.setDay(view.getDateFromDatePicker());
                        appointment.setHour(view.getTimeFromDatePicker());
                        appointment.setTreatment(view.getTreatment());
                        appointment.setTreatmentDescription(view.getTreatmentDescription());
                        appointment.setSummary(new AppointmentSummary());
                        try {
                            model.getAppointmentManager().addAppointment(appointment);
                            view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                            view.getTablePanel().refresh();
                            JOptionPane.showMessageDialog(view, "Added");
                        } catch (ApponitmentAlreadyExistsException ex) {
                            JOptionPane.showMessageDialog(view, "That Date And Time Is Busy ");
                        }
                    } else JOptionPane.showMessageDialog(view, "There Is No Such Vet With That Id!");
                } else JOptionPane.showMessageDialog(view, "There Is No Such Pet For That Customer!");
            } else JOptionPane.showMessageDialog(view, "There Is No Such Customer With That Id!");
        } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
    }

    public void deleteAppointment() {
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            Appointment appointment = model.getAppointmentManager().getArrayAppointments().get(row);
            try {
                model.getAppointmentManager().removeAppointment(appointment);
                view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                view.getTablePanel().refresh();
            } catch (AppointmentNotExistException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void updateAppointment() {

        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            Appointment appointment = model.getAppointmentManager().getArrayAppointments().get(row);
            if (view.getView().validateFields()) {
                appointment.setCustomerId(view.getCustomerId());
                if (model.getPersonManager().searchPetForCustomer(appointment.getCustomerId(), view.getPetId())) {
                    appointment.setPetId(view.getPetId());
                }
                appointment.setVetId(view.getVetId());
                appointment.setDay(view.getDateFromDatePicker());
                appointment.setHour(view.getTimeFromDatePicker());
                appointment.setTreatment(view.getTreatment());
                appointment.setTreatmentDescription(view.getTreatmentDescription());
                try {
                    model.getAppointmentManager().updateAppointment(appointment);
                } catch (AppointmentNotExistException ex) {
                    ex.printStackTrace();
                } catch (ApponitmentAlreadyExistsException ex) {
                    ex.printStackTrace();
                }
                view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                view.getTablePanel().refresh();
                JOptionPane.showMessageDialog(view, "Updated!");
            } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
        }
    }

    public void addAppointmentSummary() {
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            Appointment appointment = model.getAppointmentManager().getArrayAppointments().get(row);
            if (view.getView().validateSummaryFields()) {
                AppointmentSummary appointmentSummary = new AppointmentSummary();
                appointmentSummary.setTreatmentSummary(view.getTreatmentSummary());
                appointmentSummary.setRecommendations(view.getRecommendations());
                appointmentSummary.setMedicines(view.getMedicine());
                for (Medicine medicine : model.getMedicineManager().getMedicinesAndQuantity().keySet()) {
                    if (medicine.getName().equals(view.getMedicine()))
                        if (model.getMedicineManager().getMedicinesAndQuantity().get(medicine) - Integer.parseInt(view.getQuantity()) >= 0) {
                            try {
                                model.getMedicineManager().decreaseQuantityFromMedicineStock(medicine, Integer.parseInt(view.getQuantity()));
                                model.getAppointmentManager().addAppointmentSummary(appointment, appointmentSummary);
                                view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                                view.getTablePanel().refresh();
                                JOptionPane.showMessageDialog(view, "Added!");
                                break;
                            } catch (MedicineNotExistException | MedicineQuantityInsufficient medicineNotExistException) {
                                medicineNotExistException.printStackTrace();
                            }
                        } else JOptionPane.showMessageDialog(view, "Quantity Insufficient");

                }
            } else JOptionPane.showMessageDialog(view, "Fill All Fields!");

        }
    }

    public void deleteAppointmentSummary() {
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            Appointment appointment = model.getAppointmentManager().getArrayAppointments().get(row);
            model.getAppointmentManager().removeAppointmentSummary(appointment);
            view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
            view.getTablePanel().refresh();
        }
    }

    public void addSelectedRow() {
        AppointmentTableModel model = (AppointmentTableModel) view.getTablePanel().getTable().getModel();
        int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
        view.setCustomerId(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 0).toString());
        view.setPetId(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 1).toString());
        view.setVetId(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 2).toString());
        view.setDateFromDatePicker(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 3).toString());
        view.setTimeFromDatePicker(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 4).toString());
        view.setTreatment(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 5).toString());
        view.setTreatmentDescription(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 6).toString());
        view.setTreatmentSummary(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 7).toString());
        view.setRecommendations(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 8).toString());
        view.setMedicine(view.getTablePanel().getTable().getValueAt(selectedRowIndex, 9).toString());

    }

    @Override
    public void update(Observable o, Object arg) {
        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
        view.getView().setMedicines((HashMap<Medicine, Integer>) model.getMedicineManager().getMedicinesAndQuantity());
        setChanged();
        notifyObservers();
    }
}
