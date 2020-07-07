package Model;

public class Cat extends Pet {
    String breed;
    Boolean isCastrated;

    public Cat() {
    }

    public Cat(String petId, String name, String dateOfBirth, String color, String gender, double weight, String breed, Boolean isCastrated) {
        super(petId, name, dateOfBirth, color, gender, weight);
        this.breed = breed;
        this.isCastrated = isCastrated;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean getCastrated() {
        return isCastrated;
    }

    public void setCastrated(Boolean castrated) {
        isCastrated = castrated;
    }

    @Override
    public String toString() {
        return super.toString()+ "Cat{" +
                "breed='" + breed + '\'' +
                ", isCastrated=" + isCastrated +
                '}';
    }
}
