package Model.TablesModels;

import Model.Customer;
import Model.Person;
import Model.Vet;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> persons;
    private String [] colNames={"Id","Name", "Phone Number","Email","Address","Customer Number","Licence"};

    public PersonTableModel() {
    }

    public void setData(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getPhoneNumber();
            case 3:
                return person.getEmail();
            case 4:
                return person.getAddress();
            case 5:
                if (person instanceof Customer)
                    return ((Customer) person).getCustomerNumber();
                else return "";
            case 6:
                if (person instanceof Vet)
                    return ((Vet) person).getLicence();
                else return "";
        }
        return null;

    }
}
