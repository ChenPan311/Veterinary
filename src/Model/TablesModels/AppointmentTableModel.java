package Model.TablesModels;

import Model.Appointment;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AppointmentTableModel extends AbstractTableModel {
    private List<Appointment> appointmentList = new ArrayList<>();
    private String [] colNames={"Customer Id","Pet Id","Vet Id","Date","Time","Treatment","Treatment Description","Summary","Recommendations","Medicines"};

    public AppointmentTableModel() {
    }

    public void setData(ArrayList<Appointment> appointments){
        this.appointmentList=appointments;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return appointmentList.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment appointment = appointmentList.get(rowIndex);
        switch (columnIndex){
            case 0:
                return appointment.getCustomerId();
            case 1:
                return appointment.getPetId();
            case 2:
                return appointment.getVetId();
            case 3:
                return appointment.getDate().getDay();
            case 4:
                return  appointment.getDate().getHour();
            case 5:
                return appointment.getTreatment();
            case 6:
                return appointment.getTreatmentDescription();
            case 7:
                return appointment.getSummary().getTreatmentSummary();
            case 8:
                return appointment.getSummary().getRecommendations();
            case 9:
                return appointment.getSummary().getMedicines();
        }
        return null;
    }
}
