package View.Panels;

import Model.Appointment;
import Model.Medicine;
import Model.Person;
import Model.Pet;
import Model.TablesModels.AppointmentTableModel;
import Model.TablesModels.MedicineTableModel;
import Model.TablesModels.PersonTableModel;
import Model.TablesModels.PetTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class TablePanel extends JPanel {
    private JTable table;
    private AbstractTableModel tableModel;

    public TablePanel(AbstractTableModel abstractTableModel) {
        tableModel = abstractTableModel;
        table = new JTable(tableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public void setPersonsData(Set<Person> persons) {
        ((PersonTableModel) tableModel).setData(persons);

    }

    public void setAppointmentsData(Set<Appointment> appointments) {
        ((AppointmentTableModel) tableModel).setData(appointments);

    }

    public void setMedicineData(Map<Medicine,Integer> medicines){
        ((MedicineTableModel)tableModel).setData(medicines);

    }

    public void setPetDataForCustomer(ArrayList<Pet> pets){
        ((PetTableModel)tableModel).setData(pets);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();


    }

    public void addSelectedRowListener(MouseListener mouseListener){
        table.addMouseListener(mouseListener);
    }


}
