package Model.InterfaceModels;

import Model.Appointment;
import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;

public interface AppointmentManageInterface {
    public void addAppointment(Appointment appointment)throws ApponitmentAlreadyExistsException;
    public void removeAppointment(Appointment appointment)throws AppointmentNotExistException;

}
