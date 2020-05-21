package Controller;

import Model.Appointment;
import Model.AppointmentManager;
import Model.Customer;
import Model.CustomersAppointmentsModelView;
import Model.TablesModels.AppointmentTableModel;
import Model.TablesModels.PersonTableModel;
import View.AppointmentsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppointmentsController {
    private AppointmentsView view;
    private CustomersAppointmentsModelView model;

    public AppointmentsController(AppointmentsView view, CustomersAppointmentsModelView model) {
        this.view = view;
        this.model = model;
        view.getTablePanel().setAppointmentsData(model.getAppointmentManager().getAppointments());

        view.addAppointmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getView().validateFields()) {
                    if (model.getPersonManager().searchById(view.getView().getCustomerId_tf().getText())) {
                        if (model.getPersonManager().searchPetForCustomer(view.getView().getCustomerId_tf().getText(), view.getView().getPetId_tf().getText())) {
                            if (model.getPersonManager().searchById(view.getView().getVetId_tf().getText())) {
                                Appointment appointment = new Appointment();
                                appointment.setCustomerId(view.getView().getCustomerId_tf().getText());
                                appointment.setPetId(view.getView().getPetId_tf().getText());
                                appointment.setVetId(view.getView().getPetId_tf().getText());
                                appointment.getDate().setDay(view.getView().getDateTimePicker().getDatePicker().getText());
                                appointment.getDate().setHour(view.getView().getDateTimePicker().getTimePicker().getText());
                                appointment.setTreatment(view.getView().getTreatment_tf().getText());
                                appointment.setTreatmentDescription(view.getView().getTreatmentDescription_tf().getText());
                                model.getAppointmentManager().addAppointment(appointment);
                                view.getTablePanel().refresh();
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
                    model.getAppointmentManager().getAppointments().remove(row);
                    view.getTablePanel().refresh();
                }
            }
        });

        view.updateAppointmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    Appointment appointment = model.getAppointmentManager().getAppointmentByRowIndex(row);
                    if (view.getView().validateFields()) {
                        appointment.setCustomerId(view.getView().getCustomerId_tf().getText());
                        if(model.getPersonManager().searchPetForCustomer(appointment.getCustomerId(),view.getView().getPetId_tf().getText())) {
                            appointment.setPetId(view.getView().getPetId_tf().getText());
                        }
                        appointment.setVetId(view.getView().getPetId_tf().getText());
                        appointment.getDate().setDay(view.getView().getDateTimePicker().getDatePicker().getText());
                        appointment.getDate().setHour(view.getView().getDateTimePicker().getTimePicker().getText());
                        appointment.setTreatment(view.getView().getTreatment_tf().getText());
                        appointment.setTreatmentDescription(view.getView().getTreatmentDescription_tf().getText());
                        view.getTablePanel().refresh();
                        JOptionPane.showMessageDialog(view, "Updated!");
                    } else JOptionPane.showMessageDialog(view,"Fill All Fields!");
                }
            }

        });

        view.addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AppointmentTableModel model = (AppointmentTableModel) view.getTablePanel().getTable().getModel();
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                view.getView().getCustomerId_tf().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,0).toString());
                view.getView().getPetId_tf().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,1).toString());
                view.getView().getPetId_tf().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,2).toString());
                view.getView().getDateTimePicker().getDatePicker().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,3).toString());
                view.getView().getDateTimePicker().getTimePicker().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,4).toString());
                view.getView().getTreatment_tf().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,5).toString());
                view.getView().getTreatmentDescription_tf().setText(view.getTablePanel().getTable().getValueAt(selectedRowIndex,6).toString());
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
