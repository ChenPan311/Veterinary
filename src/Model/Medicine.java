package Model;

import java.io.Serializable;
import java.util.Objects;

public class Medicine implements Serializable {
    private String id, name, type;

    public Medicine() {
    }

    public Medicine(String  medicineId, String medicineName, String medicineType) {
        this.id = medicineId;
        this.name = medicineName;
        this.type = medicineType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;
        Medicine medicine = (Medicine) o;
        return getId().equals(medicine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
