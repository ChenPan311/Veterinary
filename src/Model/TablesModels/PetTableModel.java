package Model.TablesModels;

import Model.*;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;

public class PetTableModel extends AbstractTableModel {
    private ArrayList<Pet> pets = new ArrayList<>();
    private String[] colNames = {"Pet Id", "Name", "Date Of Birth", "Color", "Gender", "Weight", "Breed", "Size", "Castrated", "Guidance", "Type", "Info"};

    public PetTableModel() {
    }

    public void setData(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return pets.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pet pet = pets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pet.getPetId();
            case 1:
                return pet.getName();
            case 2:
                return pet.getDateOfBirth();
            case 3:
                return pet.getColor();
            case 4:
                return pet.getGender();
            case 5:
                return pet.getWeight();
            case 6:
                if (pet instanceof Dog)
                    return ((Dog) pet).getBreed();
                else if (pet instanceof Cat)
                    return ((Cat) pet).getBreed();
                else return "";
            case 7:
                if (pet instanceof Dog)
                    return ((Dog) pet).getSize();
                else return "";
            case 8:
                if (pet instanceof Dog)
                    return ((Dog) pet).getCastrated();
                else if (pet instanceof Cat)
                    return ((Cat) pet).getCastrated();
                else return "";
            case 9:
                if (pet instanceof Dog)
                    return ((Dog) pet).getGuidenceDog();
                else return "";
            case 10:
                if (pet instanceof Other)
                    return ((Other) pet).getTypeOfPet();
                else return "";
            case 11:
                if (pet instanceof Other)
                    return ((Other) pet).getInfo();
                else return "";
        }
        return null;
    }
}
