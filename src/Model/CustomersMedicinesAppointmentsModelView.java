package Model;

import View.MedicinesView;

public class CustomersMedicinesAppointmentsModelView {
    private PersonManager personManager;
    private AppointmentManager appointmentManager;
    private MedicineManager medicineManager;

    public CustomersMedicinesAppointmentsModelView(Veterinary veterinary) {
        this.personManager = veterinary.getPersonManager();
        this.appointmentManager = veterinary.getAppointmentManager();
        this.medicineManager = veterinary.getMedicineManager();
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
