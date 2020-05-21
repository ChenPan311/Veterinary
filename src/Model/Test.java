package Model;

import Controller.*;
import Model.TablesModels.AppointmentTableModel;
import Model.TablesModels.MedicineTableModel;
import Model.TablesModels.PersonTableModel;
import View.*;
import View.Panels.TablePanel;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        MedicineManager medicineManager = new MedicineManager();
        Medicine medicine = new Medicine("123", "a", "Antibiotics");
        Medicine medicine1 = new Medicine("12", "acamol", "Steroids");
        medicineManager.addMedicine(medicine, 1);
        medicineManager.addMedicine(medicine1, 2);
        PersonManager personManager = new PersonManager();
        AppointmentManager appointmentManager = AppointmentManager.singletonAppointmentManager();
        Customer customer = new Customer("chen panker", "0502141165", "chenpanlwfsa@fsk", "shodh", "1234");

        Customer customer2 = new Customer("miri mir", "089234567", "sadasc@fsk", "shdi odh", "1522");
        Vet vet = new Vet("Dr Grey", "040-5452452", "fasfjasf@gmail.com", "hfui fdbfja", "4321", "13243546576");
        personManager.addPerson(customer);
        personManager.addPerson(customer2);
        personManager.addPerson(vet);
        customer.addPetToList(new Dog("1", "Jack", "21/12/12", "Yellow", "Male", 32.6, "Lab", "Big", false, false));
        customer2.addPetToList(new Dog("3", "Mosh", "13/04/15", "Black", "Male", 32.6, "Lab", "Big", false, false));

        CustomersAppointmentsModelView model = new CustomersAppointmentsModelView(personManager, appointmentManager);
        VeterinaryMainView frame = new VeterinaryMainView("Veti");
        PersonsController controller = new PersonsController(frame.getPersonsView(), personManager);
        MedicineController medicineController = new MedicineController(medicineManager, frame.getMedicineView());
        AppointmentsController appointmentsController = new AppointmentsController(frame.getAppointmentsView(), model);

        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
