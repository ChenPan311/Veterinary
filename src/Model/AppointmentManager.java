package Model;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Model.InterfaceModels.AppointmentManageInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AppointmentManager implements AppointmentManageInterface {
    private static AppointmentManager appointmentManager;
    private Set<Appointment> appointments;
    private String fileName;
    private FileManager<Appointment> fileManager;

    private AppointmentManager(String fileName) {
        this.fileName = fileName;
        fileManager=new FileManager<>(fileName);
        appointments=fileManager.readFromFile();
    }

    public static AppointmentManager singletonAppointmentManager(String fileName) {
        if (appointmentManager == null)
            appointmentManager = new AppointmentManager(fileName);
        return appointmentManager;

    }



    private void writeAppointmentToFile() {
        fileManager.writeToFile(appointments);
    }


    public void addAppointment(Appointment appointment) throws ApponitmentAlreadyExistsException {
        if (!appointments.contains(appointment)) {
            appointments.add(appointment);
            writeAppointmentToFile();
        } else
            throw new ApponitmentAlreadyExistsException(appointment.toString() + "Already Exists");
    }

    public void removeAppointment(Appointment appointment) throws AppointmentNotExistException {
        if (appointments.contains(appointment)) {
            appointments.remove(appointment);
            writeAppointmentToFile();
        } else {
            throw new AppointmentNotExistException(appointment.toString() + "Not Exists");
        }
    }

    public void updateAppointment(Appointment appointment) throws AppointmentNotExistException, ApponitmentAlreadyExistsException {
        removeAppointment(appointment);
        addAppointment(appointment);
    }

    public void addAppointmentSummary(Appointment appointment, AppointmentSummary appointmentSummary) {
        for (Appointment appointment1 : appointments) {
            if (appointment1.equals(appointment)) {
                appointment1.setSummary(appointmentSummary);
                break;
            }
        }
        writeAppointmentToFile();
    }

    public void removeAppointmentSummary(Appointment appointment) {
        for (Appointment appointment1 : appointments) {
            if (appointment1.equals(appointment)) {
                appointment1.getSummary().setRecommendations("");
                appointment1.getSummary().setTreatmentSummary("");
                appointment1.getSummary().setMedicines("");
                break;
            }
        }
        writeAppointmentToFile();
    }

    public ArrayList<Appointment> getArrayAppointments() {
        return new ArrayList<>(appointments);
    }

    public Set<Appointment> getSetAppointments() {
        return new HashSet<>(appointments);
    }

    public Set<Appointment> getSetAppointmentsForCustomer(String id) {
        HashSet<Appointment> appointmentsForCus = new HashSet<>();
        for (Appointment appointment : appointments) {
            if (appointment.getCustomerId().equals(id))
                appointmentsForCus.add(appointment);
        }
        return new HashSet<>(appointmentsForCus);
    }

    public Appointment getAppointmentByAppointment(Appointment appointment) {
        for (Appointment appointment1 : appointments) {
            if (appointment1.equals(appointment))
                return appointment1;
        }
        return null;
    }

}


