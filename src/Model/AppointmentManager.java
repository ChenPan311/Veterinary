package Model;

import java.util.ArrayList;

public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilderResult=new StringBuilder();
        for(Appointment appointment:appointments)
            stringBuilderResult.append(appointment.toString());
        return stringBuilderResult.toString();
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    // need to add here 2 more methods from class diagram
}
