package Controller;

import Model.Medicine;
import Model.MedicineManager;
import Model.TablesModels.MedicineTableModel;
import View.MedicinesView;

import javax.swing.*;
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
        view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
    }

    public MedicineManager getModel() {
        return model;
    }

    public MedicinesView getView() {
        return view;
    }

    public void addMedicineToInventory(){
        if (view.getView().validateFields()) {
            if (!model.findMedicineId(view.getId())) {
                Medicine medicine = new Medicine();
                medicine.setId(view.getId());
                medicine.setName(view.getName());
                medicine.setType(view.getType());
                model.addMedicine(medicine, Integer.parseInt(view.getQuantity()));
                view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
                view.getTablePanel().refresh();

                JOptionPane.showMessageDialog(view, medicine.getName() + " Added");
            } else JOptionPane.showMessageDialog(view, "Medicine Already Exist!");
        } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
    }

    public void deleteMedicineFromInventory(){
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            int row = view.getTablePanel().getTable().getSelectedRow();
            String id = (String) view.getTablePanel().getTable().getValueAt(row, 0);
            for (Medicine medicine : model.getMedicinesAndQuantity().keySet()) {
                if (medicine.getId().equals(id)) {
                    model.removeMedicine(medicine);
                    view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
                    view.getTablePanel().refresh();
                    break;
                }
            }
        }
    }

    public void updateMedicineInInventory(){
        if (view.getTablePanel().getTable().getSelectedRow() != -1) {
            for (Medicine medicine : model.getMedicinesAndQuantity().keySet()) {
                if (medicine.getId().equals(view.getId())) {
                    if (view.getView().validateFields()) {
                        medicine.setId(view.getId());
                        medicine.setName(view.getName());
                        medicine.setType(view.getType());
                        model.addMedicine(medicine, Integer.parseInt(view.getQuantity()));
                        view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
                        view.getTablePanel().refresh();
                        JOptionPane.showMessageDialog(view, "Updated!");
                        break;
                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                }
            }
        }
    }

    public void mouseClicked(){
        MedicineTableModel model = (MedicineTableModel) view.getTablePanel().getTable().getModel();
        int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
        view.setId(model.getValueAt(selectedRowIndex, 0).toString());
        view.setName(model.getValueAt(selectedRowIndex, 1).toString());
        view.setType(model.getValueAt(selectedRowIndex, 2).toString());
        view.setQuantity(model.getValueAt(selectedRowIndex, 3).toString());
    }


    @Override
    public void update(Observable o, Object arg) {
        view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
        setChanged();
        notifyObservers();
    }
}

