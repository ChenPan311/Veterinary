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
    //private ArrayList<Appointment> appointments;
    private static AppointmentManager appointmentManager;
    private Set<Appointment> appointments;
    private final String fileName = "appointments2.dat";

    private AppointmentManager() {
        appointments = new HashSet<>();
        readAppointmentsFromFile();
    }

    public static AppointmentManager singletonAppointmentManager() {
        if (appointmentManager == null)
            appointmentManager = new AppointmentManager();
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


//    public void addAppointment(Appointment appointment){
//        appointments.add(appointment);
//    }
//    @Override
//    public String toString() {
//        StringBuilder stringBuilderResult=new StringBuilder();
//        for(Appointment appointment:appointments)
//            stringBuilderResult.append(appointment.toString());
//        return stringBuilderResult.toString();
//    }

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

    public ArrayList<Appointment> getAppointments(){
        return new ArrayList<Appointment>(appointments);
    }

    public Set<Appointment> getSetAppointments(){
        return appointments;
    }
}

//    public ArrayList<Appointment> getAppointments() {
//        return appointments;
//    }

//    public Appointment getAppointmentByRowIndex(int index) {
//        return appointments.get(index);
//    }
//    // need to add here 2 more methods from class diagram
//}
