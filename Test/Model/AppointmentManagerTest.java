package Model;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Exceptions.MedicineQuantityInsufficient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppointmentManagerTest {

    AppointmentManager appointmentManager;
    Appointment appointment = new Appointment(new Date("today","now"),"12","1234","43","good","very good",new AppointmentSummary("a","a","a"));

    @BeforeEach
    public void setUpMethod() {
        System.out.println("setUp");
        appointmentManager = AppointmentManager.singletonAppointmentManager("appointmentManagerTst.dat");

    }

    @Test
    void getAppointmentByAppointment()
    {

        try {
            appointmentManager.addAppointment(appointment);
        } catch (ApponitmentAlreadyExistsException e) {

        }
        assertThrows(ApponitmentAlreadyExistsException.class,
                ()->{
                    appointmentManager.addAppointment(appointment);
                });

        assertTrue(appointmentManager.getAppointmentByAppointment(appointment).equals(appointment));

    }

    @Test
    void removeAppointment()
    {
        try {
            appointmentManager.addAppointment(appointment);
        } catch (ApponitmentAlreadyExistsException e) {

        }
        assertThrows(ApponitmentAlreadyExistsException.class,
                ()->{
                    appointmentManager.addAppointment(appointment);
                });
        try {
            appointmentManager.removeAppointment(appointment);
        } catch (AppointmentNotExistException e) {

        }
        assertThrows(AppointmentNotExistException.class,
                ()->{
                    appointmentManager.removeAppointment(appointment);
                });
        assertTrue(appointmentManager.getAppointmentByAppointment(appointment) == null);
    }
}


