package Controller;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import Model.Appointment;
import Model.AppointmentSummary;
import Model.CustomersAppointmentsModelView;
import Model.Medicine;
import Model.TablesModels.AppointmentTableModel;
import View.AppointmentsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class AppointmentsController{
    private AppointmentsView view;
    private CustomersAppointmentsModelView model;

    public AppointmentsController(AppointmentsView view, CustomersAppointmentsModelView model) {
        this.view = view;
        this.model = model;
        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
        view.getView().setMedicines((HashMap<Medicine, Integer>) model.getMedicineManager().getMedicinesAndQuantity());

        view.addAppointmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getView().validateFields()) {
                    if (model.getPersonManager().searchById(view.getCustomerId())) {
                        if (model.getPersonManager().searchPetForCustomer(view.getCustomerId(), view.getPetId())) {
                            if (model.getPersonManager().searchById(view.getVetId())) {
                                Appointment appointment = new Appointment();
                                appointment.setCustomerId(view.getCustomerId());
                                appointment.setPetId(view.getPetId());
                                appointment.setVetId(view.getVetId());
                                appointment.getDate().setDay(view.getDateFromDatePicker());
                                appointment.getDate().setHour(view.getTimeFromDatePicker());
                                appointment.setTreatment(view.getTreatment());
                                appointment.setTreatmentDescription(view.getTreatmentDescription());
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
                    } else JOptionPane.showMessageDialog(view, "There Is No Such Customer With That Id!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");

            }
        });

        view.deleteAppointmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    Appointment appointment=model.getAppointmentManager().getArrayAppointments().get(row);
                    try {
                        model.getAppointmentManager().removeAppointment(appointment);
                        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                        view.getTablePanel().refresh();
                    } catch (AppointmentNotExistException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        view.updateAppointmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    Appointment appointment = model.getAppointmentManager().getArrayAppointments().get(row);
                    if (view.getView().validateFields()) {
                        appointment.setCustomerId(view.getCustomerId());
                        if(model.getPersonManager().searchPetForCustomer(appointment.getCustomerId(),view.getPetId())) {
                            appointment.setPetId(view.getPetId());
                        }
                        appointment.setVetId(view.getVetId());
                        appointment.getDate().setDay(view.getDateFromDatePicker());
                        appointment.getDate().setHour(view.getTimeFromDatePicker());
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
                    } else JOptionPane.showMessageDialog(view,"Fill All Fields!");
                }
            }

        });

        view.addAppointmentSummaryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        view.deleteAppointmentSummaryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    Appointment appointment = model.getAppointmentManager().getArrayAppointments().get(row);
                    model.getAppointmentManager().removeAppointmentSummary(appointment);
                    view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getSetAppointments());
                    view.getTablePanel().refresh();
                }
            }
        });

        view.addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AppointmentTableModel model = (AppointmentTableModel) view.getTablePanel().getTable().getModel();
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                view.setCustomerId(view.getTablePanel().getTable().getValueAt(selectedRowIndex,0).toString());
                view.setPetId(view.getTablePanel().getTable().getValueAt(selectedRowIndex,1).toString());
                view.setVetId(view.getTablePanel().getTable().getValueAt(selectedRowIndex,2).toString());
                view.setDateFromDatePicker(view.getTablePanel().getTable().getValueAt(selectedRowIndex,3).toString());
                view.setTimeFromDatePicker(view.getTablePanel().getTable().getValueAt(selectedRowIndex,4).toString());
                view.setTreatment(view.getTablePanel().getTable().getValueAt(selectedRowIndex,5).toString());
                view.setTreatmentDescription(view.getTablePanel().getTable().getValueAt(selectedRowIndex,6).toString());
                view.setTreatmentSummary(view.getTablePanel().getTable().getValueAt(selectedRowIndex,7).toString());
                view.setRecommendations(view.getTablePanel().getTable().getValueAt(selectedRowIndex,8).toString());
                view.setMedicine(view.getTablePanel().getTable().getValueAt(selectedRowIndex,9).toString());


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

}
