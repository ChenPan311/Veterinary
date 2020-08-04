package Model.interfaceModels;

import Model.Appointment;
import exceptions.AppointmentNotExistException;
import exceptions.ApponitmentAlreadyExistsException;

public interface AppointmentManageInterface {
    public void addAppointment(Appointment appointment)throws ApponitmentAlreadyExistsException;
    public void removeAppointment(Appointment appointment)throws AppointmentNotExistException;

}
