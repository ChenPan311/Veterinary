package Model;

import View.MedicinesView;

public class CustomersMedicinesAppointmentsModelView {
    private PersonManager personManager;
    private AppointmentManager appointmentManager;
    private MedicineManager medicineManager;

    public CustomersMedicinesAppointmentsModelView() {
        this.personManager = PersonManager.singletonPersonManager();
        this.appointmentManager = AppointmentManager.singletonAppointmentManager();
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
