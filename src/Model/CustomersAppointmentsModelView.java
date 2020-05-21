package Model;

public class CustomersAppointmentsModelView {
    private PersonManager personManager;
    private AppointmentManager appointmentManager;

    public CustomersAppointmentsModelView(PersonManager personManager, AppointmentManager appointmentManager) {
        this.personManager = personManager;
        this.appointmentManager = appointmentManager;
    }

    public PersonManager getPersonManager() {
        return personManager;
    }

    public AppointmentManager getAppointmentManager() {
        return appointmentManager;
    }
}
