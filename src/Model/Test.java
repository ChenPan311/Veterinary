package Model;

import Controller.AddAppointmentController;
import Controller.AddPetToCustomerController;
import Controller.MedicineController;
import Controller.RegisterCustomerController;
import View.*;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        MedicineManager medicineManager = new MedicineManager();
        Medicine medicine = new Medicine("123", "a", "b");
        medicineManager.addMedicine(medicine, 1);
        medicineManager.addMedicine(medicine, 2);
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer("chen panker", "0502141165", "chenpanlwfsa@fsk", "shodh", "1234");
        Vet vet = new Vet("Dr Grey","040-5452452","fasfjasf@gmail.com","hfui fdbfja","4321","13243546576");
        personManager.addPerson(customer);
        personManager.addPerson(vet);
        customer.addPetToList(new Dog("1","1234","Jack","21/12/12","Yellow","Male",32.6,"Lab","Big",false,false));
        AppointmentManager appointmentManager = new AppointmentManager();
        //JFrame frame = new JFrame("title test");
        VeterinaryMainView frame = new VeterinaryMainView("Veti");
        //frame.add(new AddAppointmentView());

        RegisterCustomerController controller2=new RegisterCustomerController(personManager,frame.getRegisterCustomerView());
        MedicineController medicineController=new MedicineController(medicineManager,frame.getMedicineView());
        AddPetToCustomerController controller1 = new AddPetToCustomerController(personManager, frame.getPetToCustomerView());

        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
