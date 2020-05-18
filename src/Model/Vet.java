package Model;

public class Vet extends Person {
    private String licence;

    public Vet(String name, String phoneNumber, String email, String address, String id, String licence) {
        super(name, phoneNumber, email, address, id);
        this.licence = licence;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
    // missing methods from class diagram
}
