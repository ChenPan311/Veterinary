package Model;

import Exceptions.AppointmentNotExistException;
import Exceptions.ApponitmentAlreadyExistsException;
import Model.InterfaceModels.AppointmentManageInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentManager implements AppointmentManageInterface {
    private static AppointmentManager appointmentManager;
    private Set<Appointment> appointments;
    private String fileName;

    private AppointmentManager(String fileName) {
        this.fileName = fileName;
        appointments = new HashSet<>();
        readAppointmentsFromFile();
    }

    public static AppointmentManager singletonAppointmentManager(String fileName) {
        if (appointmentManager == null)
            appointmentManager = new AppointmentManager(fileName);
        return appointmentManager;

    }

    private void readAppointmentsFromFile() {
        File file = new File(fileName);
        if (file.length() == 0) {
            return;
        }
        try (InputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            appointments = (Set<Appointment>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void writeAppointmentToFile() {
        try (OutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(appointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return new ArrayList<Appointment>(appointments);
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


