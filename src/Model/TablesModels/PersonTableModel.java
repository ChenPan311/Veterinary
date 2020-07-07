package Model.TablesModels;

import Model.Appointment;
import Model.Customer;
import Model.Person;
import Model.Vet;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonTableModel extends AbstractTableModel {
    private Set<Person> persons = new HashSet<>();
    private String[] colNames = {"Id", "Name", "Phone Number", "Email", "Address", "Customer Number", "Licence"};

    public PersonTableModel() {
    }

    public void setData(Set<Person> persons) {
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
        ArrayList<Person> personsArrayList = new ArrayList<Person>(persons);
        Person person = personsArrayList.get(rowIndex);
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
