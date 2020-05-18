package Controller;

import Model.Medicine;
import Model.MedicineManager;
import View.AddMedicineView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicineController {
    private MedicineManager model;
    private AddMedicineView view;

    public MedicineController(MedicineManager model, AddMedicineView view) {
        this.model = model;
        this.view = view;
        view.addMedicineToInventory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    if (!model.findMedicineId(view.getId_tf().getText())) {
                        Medicine medicine = new Medicine();
                        medicine.setId(view.getId_tf().getText());
                        medicine.setName(view.getName_tf().getText());
                        medicine.setType(view.getType_cb().getSelectedItem().toString());
                        model.addMedicine(medicine, Integer.parseInt(view.getQuantity_tf().getText()));
                        JOptionPane.showMessageDialog(view,medicine.getName()+" Added");
                    } else JOptionPane.showMessageDialog(view, "Medicine Already Exist!");
                } else JOptionPane.showMessageDialog(view,"Fill All Fields!");
            }
        });
    }


}
