package Controller;

import View.VeterinaryMainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MainController extends Observable {
    VeterinaryMainView view;
    PersonsController personsController;
    MedicineController medicineController;
    AppointmentsController appointmentsController;

    public MainController(VeterinaryMainView view, PersonsController personsController, MedicineController medicineController, AppointmentsController appointmentsController) {
        this.view = view;
        this.personsController = personsController;
        this.medicineController = medicineController;
        this.appointmentsController = appointmentsController;
        addObserver(personsController);
        addObserver(medicineController);
        addObserver(appointmentsController);

        view.addCustomerAddingListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
            }
        });

        view.addMedicineAddingListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
            }
        });

        view.addPetAddingListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
            }
        });
    }
}
