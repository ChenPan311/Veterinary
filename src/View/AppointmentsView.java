package View;

import Controller.AppointmentsController;
import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import Model.*;
import Model.Date;
import Model.TablesModels.AppointmentTableModel;
import Model.TablesModels.PersonTableModel;
import View.Dialogs.AddAppointmentSummary;
import View.Panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class AppointmentsView extends JPanel implements Observer {
    private TablePanel tablePanel;
    private JTable table;
    private AddAppointmentView view;
    private AppointmentsController controller;


    public AppointmentsView() {
        view = new AddAppointmentView();
        tablePanel = new TablePanel(new AppointmentTableModel());
        table=tablePanel.getTable();
        controller = AppointmentsController.getInstance(this);



        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);

        gbc.ipady = 120;
        gbc.ipadx = 3;
        gbc.weightx = 8;
        gbc.weighty = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(tablePanel, gbc);


        gbc.ipady = 3;
        gbc.weighty = 1;
        gbc.gridy = 1;
        add(view, gbc);


        setBackground(Color.ORANGE);

        tablePanel.setAppointmentsData(controller.getSetAppointments());
        getView().setMedicines((HashMap<Medicine, Integer>) controller.getMedicinesAndQuantity());

        addAppointment();
        deleteAppointment();
        updateAppointment();
        addAppointmentSummary();
        deleteAppointmentSummary();
        addSelectedRow();
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public AddAppointmentView getView() {
        return view;
    }

    public void addAppointment(){
        view.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    if (controller.searchById(getCustomerId())) {
                        if (controller.searchPetForCustomer(getCustomerId(),getPetId())) {
                            if (controller.searchById(getVetId())) {
                                try {
                                    controller.addAppointment(createDate(),getPetId(),getCustomerId(),getVetId(),getTreatment(),getTreatmentDescription(),new AppointmentSummary());
                                    refreshTablePanel();
                                    JOptionPane.showMessageDialog(view, "Added");
                                } catch (ApponitmentAlreadyExistsException ex) {
                                    JOptionPane.showMessageDialog(view, "That Date And Time Is Busy ");
                                }
                            } else JOptionPane.showMessageDialog(view, "There Is No Such Vet With That Id!");
                        } else JOptionPane.showMessageDialog(view, "There Is No Such Pet For That Customer!");
                    } else JOptionPane.showMessageDialog(view, "There Is No Such Customer With That Id!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            }
        });
    }

    public void deleteAppointment(){
        view.getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    try {
                        controller.deleteAppointment(row);
                        refreshTablePanel();
                    } catch (AppointmentNotExistException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
    }

    public void updateAppointment(){
        view.getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    if (getView().validateFields()) {
                        int row = table.getSelectedRow();
                        try {
                            controller.updateAppointment(row,createDate(),getPetId(),getCustomerId(),getVetId(),getTreatment(),getTreatmentDescription(),new AppointmentSummary());
                        } catch (AppointmentNotExistException ex) {
                            ex.printStackTrace();
                        } catch (ApponitmentAlreadyExistsException ex) {
                            ex.printStackTrace();
                        }
                        refreshTablePanel();
                        JOptionPane.showMessageDialog(view, "Updated!");
                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                }
            }
        });
    }

    public void addAppointmentSummary(){
        view.getAddSummaryBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    int row =table.getSelectedRow();
                    Appointment appointment = controller.getArrayAppointments().get(row);
                    if (getView().validateSummaryFields()) {
                        AppointmentSummary appointmentSummary = new AppointmentSummary();
                        appointmentSummary.setTreatmentSummary(getTreatmentSummary());
                        appointmentSummary.setRecommendations(getRecommendations());
                        appointmentSummary.setMedicines(getMedicine());
                        try {
                                controller.addAppointmentSummary(appointment, appointmentSummary,getMedicine(),Integer.parseInt(getQuantity()));
                                refreshTablePanel();
                                JOptionPane.showMessageDialog(view, "Added!");
                        } catch (MedicineNotExistException | MedicineQuantityInsufficient medicineNotExistException) {
                            JOptionPane.showMessageDialog(view, "Quantity Insufficient");
                        }
                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                }

            }
        });
    }

    public void deleteAppointmentSummary(){
        view.getDeleteSummaryBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    Appointment appointment = controller.getArrayAppointments().get(row);
                    controller.deleteAppointmentSummary(appointment);
                    refreshTablePanel();
                }
            }
        });
    }

    public void addSelectedRow(){
        tablePanel.addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRowIndex =table.getSelectedRow();
                setCustomerId(table.getValueAt(selectedRowIndex, 0).toString());
                setPetId(table.getValueAt(selectedRowIndex, 1).toString());
                setVetId(table.getValueAt(selectedRowIndex, 2).toString());
                setDateFromDatePicker(table.getValueAt(selectedRowIndex, 3).toString());
                setTimeFromDatePicker(table.getValueAt(selectedRowIndex, 4).toString());
                setTreatment(table.getValueAt(selectedRowIndex, 5).toString());
                setTreatmentDescription(table.getValueAt(selectedRowIndex, 6).toString());
                setTreatmentSummary(table.getValueAt(selectedRowIndex, 7).toString());
                setRecommendations(table.getValueAt(selectedRowIndex, 8).toString());
                setMedicine(table.getValueAt(selectedRowIndex, 9).toString());
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

    private Date createDate(){
        Date date =new Date();
        date.setDay(getDateFromDatePicker());
        date.setHour(getTimeFromDatePicker());
        return date;
    }
    private void  refreshTablePanel(){
        tablePanel.setAppointmentsData(controller.getSetAppointments());
        tablePanel.refresh();
    }

    public String getCustomerId() {
        return view.getCustomerId_tf().getText();
    }

    public String getPetId() {
        return view.getPetId_tf().getText();
    }

    public String getVetId() {
        return view.getVetId_tf().getText();
    }

    public String getDateFromDatePicker() {
        return view.getDateTimePicker().getDatePicker().getText();
    }

    public String getTimeFromDatePicker() {
        return view.getDateTimePicker().getTimePicker().getText();
    }

    public String getTreatment() {
        return view.getTreatment_tf().getText();
    }

    public String getTreatmentDescription() {
        return view.getTreatmentDescription_tf().getText();
    }


    public void setCustomerId(String id) {
        view.getCustomerId_tf().setText(id);
    }

    public void setPetId(String id) {
        view.getPetId_tf().setText(id);
    }

    public void setVetId(String id) {
        view.getVetId_tf().setText(id);
    }

    public void setDateFromDatePicker(String date) {
        view.getDateTimePicker().getDatePicker().setText(date);
    }

    public void setTimeFromDatePicker(String time) {
        view.getDateTimePicker().getTimePicker().setText(time);
    }

    public void setTreatment(String treatment) {
        view.getTreatment_tf().setText(treatment);
    }

    public void setTreatmentDescription(String treatmentDescription) {
        view.getTreatmentDescription_tf().setText(treatmentDescription);
    }

    public void setTreatmentSummary(String summary) {
        view.getTreatmentSummary_tf().setText(summary);
    }

    public void setRecommendations(String recommendations) {
        view.getRecommendations_tf().setText(recommendations);
    }

    public void setMedicine(String medicine) {
        view.getMedicines_cb().setSelectedItem(medicine);
    }

    public void setQuantity(String quantity) {
        view.getQuantity_tf().setText(quantity);
    }

    public String getTreatmentSummary() {
        return view.getTreatmentSummary_tf().getText();
    }

    public String getRecommendations() {
        return view.getRecommendations_tf().getText();
    }

    public String getMedicine() {
        return (String) view.getMedicines_cb().getSelectedItem();
    }

    public String getQuantity() {
        return view.getQuantity_tf().getText();
    }

    @Override
    public void update(Observable o, Object arg) {
        tablePanel.refresh();
    }
}
