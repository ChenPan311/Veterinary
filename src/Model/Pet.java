package Model;

public abstract class Pet {
    private String petId,ownerId,name,dateOfBirth,color,gender;
    private double weight;

    public Pet() {
    }

    public Pet(String petId, String ownerId, String name, String dateOfBirth, String color, String gender, double weight) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.color = color;
        this.gender = gender;
        this.weight = weight;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId='" + petId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                '}';
    }
}
