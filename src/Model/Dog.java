package Model;

public class Dog extends Pet {
    String breed,size;
    Boolean isCastrated, isGuidenceDog;

    public Dog() {
    }

    public Dog(String petId, String ownerId, String name, String dateOfBirth, String color, String gender, double weight, String breed, String size, Boolean isCastrated, Boolean isGuildenceDog) {
        super(petId, ownerId, name, dateOfBirth, color, gender, weight);
        this.breed = breed;
        this.size = size;
        this.isCastrated = isCastrated;
        this.isGuidenceDog = isGuildenceDog;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getCastrated() {
        return isCastrated;
    }

    public void setCastrated(Boolean castrated) {
        isCastrated = castrated;
    }

    public Boolean getGuidenceDog() {
        return isGuidenceDog;
    }

    public void setGuidenceDog(Boolean guidenceDog) {
        isGuidenceDog = guidenceDog;
    }

    @Override
    public String toString() {
        return super.toString()+ "Dog{" +
                "breed='" + breed + '\'' +
                ", size='" + size + '\'' +
                ", isCastrated=" + isCastrated +
                ", isGuidenceDog=" + isGuidenceDog +
                '}';
    }
}
