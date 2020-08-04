package view;

import controllers.MedicineController;
import Model.tablesModels.MedicineTableModel;
import view.panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class MedicinesView extends JPanel implements Observer {
    private TablePanel tablePanel;
    private AddMedicineView view;
    private MedicineController controller;

    public MedicinesView() {
        tablePanel=new TablePanel(new MedicineTableModel());
        view=new AddMedicineView();
        controller = MedicineController.getInstance(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);

        gbc.ipady=120;
        gbc.ipadx=3;
        gbc.weightx=4;
        gbc.weighty=5;
        gbc.gridx=0;
        gbc.gridy=0;
        add(tablePanel,gbc);


        gbc.ipady=3;
        gbc.weighty=1;
        gbc.gridy=1;
        add(view,gbc);

        setBackground(Color.ORANGE);

        tablePanel.setMedicineData(controller.getMedicinesAndQuantity());

        addMedicineToInventory();
        deleteMedicineFromInventory();
        updateMedicineInInventory();
        mouseClicked();
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public AddMedicineView getView() {
        return view;
    }


    public void addMedicineToInventory(){
        view.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.validateFields()) {
                    if (!controller.findMedicineId(getId())) {
                        controller.addMedicine(getId(),getName(),getType(), Integer.parseInt(getQuantity()));
                        tablePanel.setMedicineData(controller.getMedicinesAndQuantity());
                        tablePanel.refresh();
                        JOptionPane.showMessageDialog(view, getName() + " Added");
                    } else JOptionPane.showMessageDialog(view, "Medicine Already Exist!");
                } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
            }
        });
    }

    public void deleteMedicineFromInventory(){
        view.getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = tablePanel.getTable();
                if (table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    String id = (String) table.getValueAt(row, 0);
                    if (controller.removeMedicine(id)) {
                        tablePanel.setMedicineData(controller.getMedicinesAndQuantity());
                        tablePanel.refresh();

                    }
                }
            }

        });
    }

    public void updateMedicineInInventory(){
        view.getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablePanel.getTable().getSelectedRow() != -1) {
                    if (getView().validateFields()) {
                       if(controller.updateMedicine(getId(),getName(),getType(), Integer.parseInt(getQuantity()))) {
                           tablePanel.setMedicineData(controller.getMedicinesAndQuantity());
                           tablePanel.refresh();
                           JOptionPane.showMessageDialog(view, "Updated!");
                       } else JOptionPane.showMessageDialog(view, "Can't Update this medicine!");

                    } else JOptionPane.showMessageDialog(view, "Fill All Fields!");
                }

            }
        });
    }

    public void mouseClicked(){
        tablePanel.addSelectedRowListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MedicineTableModel model = (MedicineTableModel) tablePanel.getTable().getModel();
                int selectedRowIndex = tablePanel.getTable().getSelectedRow();
                setId(model.getValueAt(selectedRowIndex, 0).toString());
                setName(model.getValueAt(selectedRowIndex, 1).toString());
                setType(model.getValueAt(selectedRowIndex, 2).toString());
                setQuantity(model.getValueAt(selectedRowIndex, 3).toString());
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

    public String getId(){
        return view.getId_tf().getText();
    }
    public String getName(){
        return view.getName_tf().getText();
    }
    public String getType(){
        return view.getType_cb().getSelectedItem().toString();
    }
    public String getQuantity(){
        return view.getQuantity_tf().getText();
    }

    public void setId(String id){
        view.getId_tf().setText(id);
    }
    public void setName(String name){
        view.getName_tf().setText(name);
    }
    public void setType(String type){
        view.getType_cb().setSelectedItem(type);
    }
    public void setQuantity(String quantity){ view.getQuantity_tf().setText(quantity); }

    @Override
    public void update(Observable o, Object arg) {
        tablePanel.refresh();
    }
}
