package Model;

import View.MedicinesView;

public class CustomersAppointmentsModelView {
    private PersonManager personManager;
    private AppointmentManager appointmentManager;
    private MedicineManager medicineManager;

    public CustomersAppointmentsModelView(PersonManager personManager, AppointmentManager appointmentManager, MedicineManager medicineManager) {
        this.personManager = personManager;
        this.appointmentManager = appointmentManager;
        this.medicineManager = medicineManager;
    }

    public PersonManager getPersonManager() {
        return personManager;
    }

    public AppointmentManager getAppointmentManager() {
        return appointmentManager;
    }

    public MedicineManager getMedicineManager() {
        return medicineManager;
    }

}
