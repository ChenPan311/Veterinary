package Controller;

import Model.Appointment;
import Model.AppointmentManager;
import Model.Person;
import Model.PersonManager;
import View.AddAppointmentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAppointmentController {
    private AddAppointmentView view;
    private AppointmentManager model;
    private PersonManager personManager;

    public AddAppointmentController(AddAppointmentView view, AppointmentManager model, PersonManager personManager) {
        this.view = view;
        this.model = model;
        this.personManager = personManager;
        view.addAppointmentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    if (personManager.searchById(view.getCustomerId_tf().getText())) {
                        if (personManager.searchPetForCustomer(view.getCustomerId_tf().getText(), view.getPetId_tf().getText())) {
                            if (personManager.searchById(view.getVetId_tf().getText())) {
                                Appointment appointment = new Appointment();
                                appointment.setCustomerId(view.getCustomerId_tf().getText());
                                appointment.setPetId(view.getPetId_tf().getText());
                                appointment.setVetId(view.getPetId_tf().getText());
                                appointment.getDate().setDay(view.getDateTimePicker().getDatePicker().getText());
                                appointment.getDate().setHour(view.getDateTimePicker().getTimePicker().getText());
                                appointment.setTreatment(view.getTreatment_tf().getText());
                                appointment.setTreatmentDescription(view.getTreatmentDescription_tf().getText());
                                model.addAppointment(appointment);
                                System.out.println(appointment);
                                JOptionPane.showMessageDialog(view, "Added");
                            } else JOptionPane.showMessageDialog(view, "There Is No Such Vet With That Id!");
                        } else JOptionPane.showMessageDialog(view, "There Is No Such Pet For That Customer!");
                    } else JOptionPane.showMessageDialog(view, "There Is No Such Customer With That Id!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");


                //first check if customer id exist in person manager,
                //if exist, check if this customer has a pet with that pet id,
                //if exist, check if vet id is correct,
                //than get time and date and verify that they are in the range,
                //check that all fields are not empty, than accept Add btn;
            }
        });
    }


}
