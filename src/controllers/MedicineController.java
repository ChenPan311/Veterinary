package controllers;

import Model.Medicine;
import Model.MedicineManager;
import view.MedicinesView;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class MedicineController extends Observable implements Observer {
    private static MedicineController medicineController;
    private MedicineManager model;
    private MedicinesView view;

    public static MedicineController getInstance(MedicinesView view){
        if(medicineController==null){
            medicineController = new MedicineController(view);
        }
        return medicineController;
    }

    private MedicineController(MedicinesView view) {
        this.model = MedicineManager.singletonMedicineManager("medicines.dat");
        this.view = view;
        addObserver(view);
    }

    public MedicineManager getModel() {
        return model;
    }

    public MedicinesView getView() {
        return view;
    }


    @Override
    public void update(Observable o, Object arg) {
 //       view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
        setChanged();
        notifyObservers();
    }

    public boolean findMedicineId(String id) {
        return model.findMedicineId(id);
    }

    public Map<Medicine, Integer> getMedicinesAndQuantity() {
        return model.getMedicinesAndQuantity();
    }

    public boolean removeMedicine(String id) {
        Map<Medicine, Integer> medicinesAndQuantity = model.getMedicinesAndQuantity();
        for (Medicine medicine : medicinesAndQuantity.keySet()) {
            if (medicine.getId().equals(id)) {
                model.removeMedicine(medicine);
                return true;
            }
        }
        return false;
    }

    public void addMedicine(String id, String name, String type, int quantity) {
        Medicine medicine = new Medicine(id,name,type);
        model.addMedicine(medicine, quantity);
    }

    public boolean updateMedicine(String id, String name, String type, int quantity) {
        Medicine medicine = new Medicine(id,name,type);
        return model.updateMedicine(medicine,quantity);
    }
}

