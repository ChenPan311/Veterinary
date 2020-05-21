package Model.TablesModels;

import Model.Medicine;

import javax.swing.table.AbstractTableModel;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;

public class MedicineTableModel extends AbstractTableModel {
    private HashMap<Medicine,Integer> medicines = new HashMap<>();
    private String[] colNames={"Medicine Id","Name","Type","Quantity"};

    public MedicineTableModel() {
    }

    public void setData(HashMap<Medicine,Integer> medicines){
        this.medicines=medicines;

    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return medicines.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<Medicine> details = new ArrayList<>(medicines.keySet());
        ArrayList<Integer> quantity = new ArrayList<>(medicines.values());
        Medicine medicineDetail=details.get(rowIndex);
        int medicineQuantity = quantity.get(rowIndex);
        switch (columnIndex){
            case 0:
                return medicineDetail.getId();
            case 1:
                return medicineDetail.getName();
            case 2:
                return medicineDetail.getType();
            case 3:
                return medicineQuantity;
        }
        return null;
    }
}
