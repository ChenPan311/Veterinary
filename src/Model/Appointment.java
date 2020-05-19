package Model;

import java.util.Objects;

public class Appointment {
    private Date date = new Date();
    private String treatment,treatmentDescription,petId,customerId,vetId;
    private AppointmentSummary summary = new AppointmentSummary();

    public Appointment() {}

    public Appointment(Date date, String petId, String  customerId, String vetId, String treatment, String treatmentDescription, AppointmentSummary summary) {
        this.date = date;
        this.petId = petId;
        this.customerId = customerId;
        this.vetId = vetId;
        this.treatment = treatment;
        this.treatmentDescription = treatmentDescription;
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public AppointmentSummary getSummary() {
        return summary;
    }

    public void setSummary(AppointmentSummary summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return getPetId() == that.getPetId() &&
                getCustomerId() == that.getCustomerId() &&
                getVetId() == that.getVetId() &&
                that.getDate().equals(getDate());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", petId=" + petId +
                ", customerId=" + customerId +
                ", vetId=" + vetId +
                ", treatment='" + treatment + '\'' +
                ", treatmentDescription='" + treatmentDescription + '\'' +
                ", summary=" + summary +
                '}';
    }
}
