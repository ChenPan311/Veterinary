package Controller;

import View.VeterinaryMainView;

import java.util.Observable;

public class MainController extends Observable {
    private static MainController mainController;
    private VeterinaryMainView view;
    private PersonsController personsController;
    private MedicineController medicineController;
    private AppointmentsController appointmentsController;

    public static MainController getInstance(VeterinaryMainView view){
        if(mainController==null){
            mainController = new MainController(view);
        }
        return mainController;
    }

    private MainController(VeterinaryMainView view) {
        this.view = view;
        this.personsController = PersonsController.getInstance(view.getPersonsView());
        this.medicineController = MedicineController.getInstance(view.getMedicineView());
        this.appointmentsController = AppointmentsController.getInstance(view.getAppointmentsView());
        addObserver(personsController);
        addObserver(medicineController);
        addObserver(appointmentsController);
    }

    public void update(){
        setChanged();
        notifyObservers();
    }

}
