package Controller;

import Model.Medicine;
import Model.MedicineManager;
import Model.TablesModels.MedicineTableModel;
import Model.TablesModels.PersonTableModel;
import View.MedicinesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MedicineController {
    private MedicineManager model;
    private MedicinesView view;

    public MedicineController(MedicineManager model, MedicinesView view) {
        this.model = model;
        this.view = view;
        view.getTablePanel().setMedicineData(model.getMedicinesAndQuantity());
        view.addMedicineToInventory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getView().validateFields()) {
                    if (!model.findMedicineId(view.getView().getId_tf().getText())) {
                        Medicine medicine = new Medicine();
                        medicine.setId(view.getView().getId_tf().getText());
                        medicine.setName(view.getView().getName_tf().getText());
                        medicine.setType(view.getView().getType_cb().getSelectedItem().toString());
                        model.addMedicine(medicine, Integer.parseInt(view.getView().getQuantity_tf().getText()));
                        view.getTablePanel().refresh();
                        JOptionPane.showMessageDialog(view, medicine.getName() + " Added");
                    } else JOptionPane.showMessageDialog(view, "Medicine Already Exist!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            }
        });

        view.deleteMedicineFromInventory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    int row = view.getTablePanel().getTable().getSelectedRow();
                    String id = (String) view.getTablePanel().getTable().getValueAt(row, 0);
                    for (Medicine medicine : model.getMedicinesAndQuantity().keySet()) {
                        if (medicine.getId().equals(id))
                            model.getMedicinesAndQuantity().remove(medicine);
                        view.getTablePanel().refresh();
                    }
                }
            }
        });

        view.updateMedicineInInventory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTablePanel().getTable().getSelectedRow() != -1) {
                    for (Medicine medicine : model.getMedicinesAndQuantity().keySet()) {
                        if (medicine.getId().equals(view.getView().getId_tf().getText())) {
                            if (view.getView().validateFields()) {
                                medicine.setId(view.getView().getId_tf().getText());
                                medicine.setName(view.getView().getName_tf().getText());
                                medicine.setType(view.getView().getType_cb().getSelectedItem().toString());
                                model.getMedicinesAndQuantity().put(medicine, Integer.parseInt(view.getView().getQuantity_tf().getText()));
                                view.getTablePanel().refresh();
                                JOptionPane.showMessageDialog(view, "Updated!");
                                break;
                            } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                        }
                    }
                }

            }
        });

        view.addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MedicineTableModel model = (MedicineTableModel) view.getTablePanel().getTable().getModel();
                int selectedRowIndex = view.getTablePanel().getTable().getSelectedRow();
                view.getView().getId_tf().setText(model.getValueAt(selectedRowIndex, 0).toString());
                view.getView().getName_tf().setText(model.getValueAt(selectedRowIndex, 1).toString());
                view.getView().getType_cb().setSelectedItem(model.getValueAt(selectedRowIndex, 2));
                view.getView().getQuantity_tf().setText(model.getValueAt(selectedRowIndex, 3).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }


}

