package Model;

public class Other extends Pet {

    String typeOfPet,info;

    public Other() {
    }

    public Other(String petId, String name, String dateOfBirth, String color, String gender, double weight, String typeOfPet, String info) {
        super(petId, name, dateOfBirth, color, gender, weight);
        this.typeOfPet = typeOfPet;
        this.info = info;
    }

    public String getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(String typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return super.toString()+ "Other{" +
                "typeOfPet='" + typeOfPet + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
