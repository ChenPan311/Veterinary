package Model;

import View.MedicinesView;

public class CustomersMedicinesAppointmentsModelView {
    private PersonManager personManager;
    private AppointmentManager appointmentManager;
    private MedicineManager medicineManager;

    public CustomersMedicinesAppointmentsModelView() {
        this.personManager = PersonManager.singletonPersonManager("persons3");
        this.appointmentManager = AppointmentManager.singletonAppointmentManager("appointments2.dat");
        this.medicineManager = MedicineManager.singletonMedicineManager("medicines.dat");
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
