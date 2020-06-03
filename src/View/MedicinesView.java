package View;

import Model.MedicineManager;
import Model.TablesModels.MedicineTableModel;
import View.Panels.TablePanel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class MedicinesView extends JPanel implements Observer {
    private TablePanel tablePanel;
    private AddMedicineView view;

    public MedicinesView() {
        tablePanel=new TablePanel(new MedicineTableModel());
        view=new AddMedicineView();

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
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public AddMedicineView getView() {
        return view;
    }

    public void addSelectedRowListener(MouseListener mouseListener){
        tablePanel.getTable().addMouseListener(mouseListener);
    }

    public void addMedicineToInventory(ActionListener actionListener) {
        view.addMedicineToInventory(actionListener);
    }

    public void deleteMedicineFromInventory(ActionListener actionListener){
        view.deleteMedicineFromInventory(actionListener);
    }

    public void updateMedicineInInventory(ActionListener actionListener){
        view.updateMedicineInInventory(actionListener);
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
